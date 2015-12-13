package com.smapley.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Result result = new Result();
		try {
			String user_id = request.getParameter("user_id");
			String skey = request.getParameter("skey");
			String truename = request.getParameter("truename");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			System.out.println("--Account--" + truename + "--" + phone + "--"
					+ birthday+"--"+skey);
			
			Transaction transaction = HibernateSessionFactory
					.getSession().beginTransaction();
			UserDAO userDAO = new UserDAO();
			// 根据id查询
			User user = userDAO.findById(Integer.parseInt(user_id));
			System.out.println("---"+user.getSkey()+"----"+skey);
			if (user != null) {
				// 判断skey
				if (user.getSkey().equals(skey)) {
					// 设置新信息
					user.setTruename(truename);
					user.setPhone(phone);
					user.setBirthday(new Timestamp(Long.parseLong(birthday)));					
					userDAO.attachDirty(user);	
					result.flag = MyData.SUCC;
					result.details = "";
					result.data = JSON.toJSONString(new UserEntity(user));

				} else {
					result.flag = MyData.OutLogin;
					result.details = MyData.ERR_OutLogin;
				}
			} else {
				result.details = MyData.ERR_NoUser;
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
