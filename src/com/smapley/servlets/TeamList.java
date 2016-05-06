package com.smapley.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.ProUse;
import com.smapley.bean.Project;
import com.smapley.bean.TasUse;
import com.smapley.bean.Task;
import com.smapley.bean.User;
import com.smapley.db.entity.TaskEntity;
import com.smapley.db.entity.UserEntity;
import com.smapley.db.modes.ProUseMode;
import com.smapley.db.modes.Result;
import com.smapley.db.modes.TaskMode;
import com.smapley.db.service.XDAO;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/TeamList")
public class TeamList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeamList() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Result result = new Result();
		try {
			String time = request.getParameter("time");
			String userId = request.getParameter("userId");
			String projectId = request.getParameter("projectId");
			System.out.println("--TeamList--");

			User user = XDAO.userDAO.findById(Integer.parseInt(userId));
			Project project = XDAO.projectDAO.findById(Integer
					.parseInt(projectId));
			List<ProUse> proUses = XDAO.proUseDAO.findByProperty("project",
					project);
			List<ProUseMode> proUseModes = new ArrayList<ProUseMode>();
			for (ProUse proUse : proUses) {
				ProUseMode proUseMode = new ProUseMode(proUse,(long)0);
				proUseModes.add(proUseMode);
			}
			// 返回数据
			result.flag = MyData.SUCC;
			result.details = "";
			result.data = JSON.toJSONString(proUseModes);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--TeamList--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}
}
