package com.smapley.servlets;

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
import com.smapley.db.entity.UserEntity;
import com.smapley.db.modes.Result;
import com.smapley.db.service.XDAO;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("--登陆--" + username + "--" + password);
			// 根据用户名查询
			User user = XDAO.userDAO.findByUsername(username)
					.get(0);

			// 判断密码
			if (user.getPassword().equals(password)) {
				// 创建Session
				HttpSession session = request.getSession();
				// 设置新的skey 并保存
				user.setSkey(session.getId());
				user.setRefresh(new Timestamp(System.currentTimeMillis()));
				XDAO.userDAO.attachDirty(user);
				result.flag = MyData.SUCC;
				result.details = "";
				result.data = JSON.toJSONString(new UserEntity(user));
			} else {
				result.details = MyData.ERR_PASSWORD;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.details = MyData.ERR_USERNAME2;
		}
		System.out.println("--登陆--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}
}
