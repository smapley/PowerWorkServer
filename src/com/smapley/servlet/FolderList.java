package com.smapley.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.Folder;
import com.smapley.bean.Project;
import com.smapley.bean.User;
import com.smapley.dao.ProjectDAO;
import com.smapley.mode.FolderEntity;
import com.smapley.mode.Result;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/FolderList")
public class FolderList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProjectDAO projectDAO = ProjectDAO.getFromApplicationContext(MyData
			.getCXT());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FolderList() {
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
			String pro_id = request.getParameter("pro_id");
			System.out.println("--FolderList--" + pro_id);

			HttpSession session = request.getSession(false);
			if (session != null) {
				User user = (User) session.getAttribute(
						"user");
				Project project = projectDAO.findById(Integer.parseInt(pro_id));
				List<FolderEntity> listFolder = new ArrayList<FolderEntity>();
				for (Folder folder : (Set<Folder>) project.getFolders()) {
					listFolder.add(new FolderEntity(folder));
					listFolder.addAll(getFolder(folder));
				}
				// 返回数据
				result.flag = MyData.SUCC;
				result.details = "";
				result.data = JSON.toJSONString(listFolder);

			} else {
				result.flag = MyData.OutLogin;
				result.details = MyData.ERR_OutLogin;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--FolderList--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}

	private List<FolderEntity> getFolder(Folder folder) {
		List<FolderEntity> listFolder = new ArrayList<FolderEntity>();
		Set<Folder> setFolder = (Set<Folder>) folder.getFolders();
		if (setFolder != null && !setFolder.isEmpty())
			for (Folder folder1 : setFolder) {
				listFolder.add(new FolderEntity(folder1));
				listFolder.addAll(getFolder(folder1));
			}
		return listFolder;
	}
}
