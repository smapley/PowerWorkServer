package com.smapley.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.User;
import com.smapley.db.entity.UserEntity;
import com.smapley.db.modes.Result;
import com.smapley.db.service.XDAO;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/JoinProject")
public class JoinProject extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Result result = new Result();
		try {

			String truename = request.getParameter("truename");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String userId = request.getParameter("userId");
			System.out.println("--JoinProject--" + truename + "--" + phone
					+ "--" + birthday);
			User user = XDAO.userDAO.findById(Integer.parseInt(userId));
			// 判断skey
			// 设置新信息
			user.setTruename(truename);
			user.setPhone(phone);
			user.setBirthday(new Timestamp(Long.parseLong(birthday)));
			user.setRefresh(new Timestamp(System.currentTimeMillis()));
			XDAO.userDAO.attachDirty(user);
			request.getSession().setAttribute("user", user);
			result.flag = MyData.SUCC;
			result.details = "";
			result.data = JSON.toJSONString(new UserEntity(user));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--JoinProject--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}
}
