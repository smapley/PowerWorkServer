package com.smapley.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javassist.expr.NewArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.Feedbacks;
import com.smapley.bean.Message;
import com.smapley.bean.Project;
import com.smapley.bean.User;
import com.smapley.db.entity.MessageEntity;
import com.smapley.db.modes.Result;
import com.smapley.db.service.XDAO;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendMessage() {
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
			String data = request.getParameter("data");
			String userId = request.getParameter("userId");
			String userId2 = request.getParameter("userId2");
			String projectId = request.getParameter("projectId");
			System.out.println("--SendMessage--" + data);
			User user = XDAO.userDAO.findById(Integer.parseInt(userId));
			User user2 = XDAO.userDAO.findById(Integer.parseInt(userId2));
			Message message =new Message();
			message.setUserBySrcUseId(user);
			message.setUserByUseId(user2);
			if(projectId!=null){
				Project project=XDAO.projectDAO.findById(Integer.parseInt(projectId));
				message.setProject(project);
				message.setType(1);
				message.setDetails("邀请加入 "+project.getName());
			}else{
				message.setType(0);
				message.setDetails(data);
			}			
			message.setRefresh(new Timestamp(System.currentTimeMillis()));
			message.setCreDate(new Timestamp(System.currentTimeMillis()));
			message.setState(0);
			XDAO.messageDAO.save(message);
			 
			// 返回数据
			result.flag = MyData.SUCC;
			result.details = "";
			result.data=JSON.toJSONString(new MessageEntity(message));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--SendMessage--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}
}

