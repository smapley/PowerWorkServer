package com.smapley.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.Folder;
import com.smapley.bean.FolderDAO;
import com.smapley.bean.User;
import com.smapley.entity.FolderEntity;
import com.smapley.mode.Result;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/AddFolder")
public class AddFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FolderDAO folderDAO = FolderDAO.getFromApplicationContext(MyData
			.getCXT());

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
			System.out.println("--AddFolder--" + fol_id + "--" + name);

			HttpSession session = request.getSession(false);
			if (session != null) {
				User user = (User) session.getAttribute(
						"user");
					Folder folder0 = folderDAO.findById(Integer.decode(fol_id));
					Folder folder = new Folder();
					folder.setName(name);
					folder.setFolder(folder0);
					folder.setUser(user);
					folderDAO.save(folder);
					// 返回数据
					result.flag = MyData.SUCC;
					result.details = "";
					result.data = JSON.toJSONString(new FolderEntity(folder));

				} else {
					result.flag = MyData.OutLogin;
					result.details = MyData.ERR_OutLogin;
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--AddFolder--result--" + result.flag + "--" + result.details
				+ "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}
}
