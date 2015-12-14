package com.smapley.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.User;
import com.smapley.dao.UserDAO;
import com.smapley.mode.Result;
import com.smapley.mode.UserEntity;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO =UserDAO.getFromApplicationContext(MyData.getCXT());
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
			User user = userDAO.findByUsername(username).get(0);
			// 判断密码
			if (user.getPassword().equals(password)) {
				String skey = getRandomString(20);
				// 设置skey并保存
				user.setSkey(skey);				
				userDAO.attachDirty(user);	
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
		System.out.println("--result--" + result.flag + "--" + result.details
				+ "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}

	/**
	 * 随机生成字符串
	 * 
	 * @param length
	 * @return
	 */
	private String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
