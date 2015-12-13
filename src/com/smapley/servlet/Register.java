package com.smapley.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.alibaba.fastjson.JSON;
import com.smapley.HibernateSessionFactory;
import com.smapley.bean.User;
import com.smapley.bean.UserDAO;
import com.smapley.mode.Result;
import com.smapley.mode.UserEntity;
import com.smapley.utils.MyData;

@WebServlet("/Register")
public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public Register() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Result result = new Result();

		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			System.out.println("--注册--" + username + "--" + password);
			
			Transaction transaction=HibernateSessionFactory.getSession().beginTransaction();
			UserDAO userDAO=new UserDAO();
			// 查询是否存在相同用户名
			@SuppressWarnings("unchecked")
			List<User> list = userDAO.findByUsername(username);
			if (list.isEmpty()) {
				// 不存在相同用户名，插入新用户
				User user = new User();
				user.setUsername(username);
				user.setTruename(username);
				user.setPassword(password);
				user.setPhone(phone);
				user.setCreDate(new Timestamp(System.currentTimeMillis()));
				user.setBirthday(new Timestamp(System.currentTimeMillis()));
				user=userDAO.merge(user);			
				System.out.println(user.getCreDate().toString());
				result.data = JSON.toJSONString(new UserEntity(user));
				result.details = "";
				result.flag = MyData.SUCC;
			} else {
				// 存在相同用户名
				result.details = MyData.ERR_USERNAME;
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--result--" + result.flag + "--" + result.details
				+ "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}
}
