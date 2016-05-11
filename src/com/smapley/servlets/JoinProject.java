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
import com.smapley.bean.Message;
import com.smapley.bean.ProUse;
import com.smapley.db.modes.ProUseMode;
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

			String modeId = request.getParameter("modeId");
			String type = request.getParameter("type");
			System.out.println("--JoinProject--" + modeId + "--" + type);
			if (type.equals("1")) {
				Message message = XDAO.messageDAO.findById(Integer
						.parseInt(modeId));
				ProUse proUse = new ProUse();
				proUse.setProject(message.getProject());
				proUse.setUser(message.getUserByUseId());
				proUse.setRank(1);
				proUse.setRefresh(new Timestamp(System.currentTimeMillis()));
				proUse.setState(0);
				XDAO.proUseDAO.save(proUse);
				result.flag = MyData.SUCC;
				result.details = "";
				result.data = JSON.toJSONString(new ProUseMode(proUse, 0));
			}

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
