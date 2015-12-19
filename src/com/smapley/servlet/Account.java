package com.smapley.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.User;
import com.smapley.bean.UserDAO;
import com.smapley.entity.UserEntity;
import com.smapley.mode.Result;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Account")
public class Account extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = UserDAO
			.getFromApplicationContext(MyData.getCXT());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Account() {
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
			System.out.println("--Account--" + truename + "--" + phone + "--"
					+ birthday);
			HttpSession session = request.getSession(false);
			if (session != null) {
				User user = (User) session.getAttribute(
						"user");
				// 判断skey
				// 设置新信息
				user.setTruename(truename);
				user.setPhone(phone);
				user.setBirthday(new Timestamp(Long.parseLong(birthday)));
				userDAO.attachDirty(user);
				request.getSession().setAttribute("user", user);
				result.flag = MyData.SUCC;
				result.details = "";
				result.data = JSON.toJSONString(new UserEntity(user));

			} else {
				result.flag = MyData.OutLogin;
				result.details = MyData.ERR_OutLogin;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--Account--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}
}
