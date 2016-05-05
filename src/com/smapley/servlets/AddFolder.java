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
import com.smapley.bean.Folder;
import com.smapley.bean.User;
import com.smapley.db.entity.FolderEntity;
import com.smapley.db.modes.Result;
import com.smapley.db.service.XDAO;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/AddFolder")
public class AddFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFolder() {
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
			String name = request.getParameter("name");
			String fol_id = request.getParameter("fol_id");
			String userId = request.getParameter("userId");
			System.out.println("--AddFolder--" + fol_id + "--" + name);
			User user = XDAO.userDAO.findById(Integer.parseInt(userId));
			Folder folder0 = XDAO.folderDAO.findById(Integer.decode(fol_id));
			Folder folder = new Folder();
			folder.setName(name);
			folder.setFolder(folder0);
			folder.setUser(user);
			folder.setRefresh(new Timestamp(System.currentTimeMillis()));
			folder.setState(0);
			XDAO.folderDAO.save(folder);
			// 返回数据
			result.flag = MyData.SUCC;
			result.details = "";
			result.data = JSON.toJSONString(new FolderEntity(folder));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--AddFolder--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}
}
