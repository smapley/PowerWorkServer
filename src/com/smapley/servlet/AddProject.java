package com.smapley.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.Dynamic;
import com.smapley.bean.DynamicDAO;
import com.smapley.bean.Folder;
import com.smapley.bean.FolderDAO;
import com.smapley.bean.ProUse;
import com.smapley.bean.ProUseDAO;
import com.smapley.bean.Project;
import com.smapley.bean.ProjectDAO;
import com.smapley.bean.User;
import com.smapley.db.modes.ProjectMode;
import com.smapley.db.modes.Result;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/AddProject")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProjectDAO projectDAO = ProjectDAO.getFromApplicationContext(MyData
			.getCXT());
	private ProUseDAO proUseDAO = ProUseDAO.getFromApplicationContext(MyData
			.getCXT());
	private DynamicDAO dynamicDAO = DynamicDAO.getFromApplicationContext(MyData
			.getCXT());
	private FolderDAO folderDAO = FolderDAO.getFromApplicationContext(MyData
			.getCXT());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProject() {
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
			System.out.println("--AddProject--" + name);
			
			HttpSession session = request.getSession(false);
			if (session != null) {
				User user = (User) session.getAttribute(
						"user");
				boolean isHad = false;
				for (ProUse prouse : (Set<ProUse>) user.getProUses()) {
					if (prouse.getProject().getName().equals(name)) {
						isHad = true;
						break;
					}
				}
				if (!isHad) {
					// 设置新信息
					Project project = new Project();
					project.setName(name);
					project.setCreDate(new Timestamp(System.currentTimeMillis()));
					project.setRefresh(new Timestamp(System.currentTimeMillis()));
					project.setState(0);
					projectDAO.save(project);
					ProUse prouse = new ProUse();
					prouse.setUser(user);
					prouse.setProject(project);
					prouse.setRank(0);
					prouse.setRefresh(new Timestamp(System.currentTimeMillis()));
					prouse.setState(0);
					proUseDAO.save(prouse);
					Dynamic dynamic = new Dynamic();
					dynamic.setUser(user);
					dynamic.setProject(project);
					dynamic.setType(0);
					dynamic.setPicUrl(project.getPicUrl());
					dynamic.setCreDate(new Timestamp(System.currentTimeMillis()));
					dynamic.setRefresh(new Timestamp(System.currentTimeMillis()));
					dynamic.setState(0);
					dynamicDAO.save(dynamic);
					Folder folder = new Folder();
					folder.setProject(project);
					folder.setUser(user);
					folder.setName(name);
					folder.setRefresh(new Timestamp(System.currentTimeMillis()));
					folder.setState(0);
					folderDAO.save(folder);
					Folder folder1 = new Folder();
					folder1.setFolder(folder);
					folder1.setUser(user);
					folder1.setName("图片");
					folder1.setRefresh(new Timestamp(System.currentTimeMillis()));
					folder1.setState(0);
					folderDAO.save(folder1);
					Folder folder2 = new Folder();
					folder2.setFolder(folder);
					folder2.setUser(user);
					folder2.setName("声音");
					folder2.setRefresh(new Timestamp(System.currentTimeMillis()));
					folder2.setState(0);
					folderDAO.save(folder2);
					project=projectDAO.findByExample(project).get(0);
					// 返回数据
					result.flag = MyData.SUCC;
					result.details = "";
					result.data = JSON.toJSONString(new ProjectMode(project,0));
				} else {
					result.details = MyData.ERR_ProjectName;
				}
			} else {
				result.flag = MyData.OutLogin;
				result.details = MyData.ERR_OutLogin;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--AddProject--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}
}
