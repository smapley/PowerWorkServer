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

import org.hibernate.Transaction;

import com.alibaba.fastjson.JSON;
import com.smapley.HibernateSessionFactory;
import com.smapley.bean.File;
import com.smapley.bean.Folder;
import com.smapley.bean.Project;
import com.smapley.bean.ProjectDAO;
import com.smapley.bean.User;
import com.smapley.bean.UserDAO;
import com.smapley.mode.FileEntity;
import com.smapley.mode.Result;
import com.smapley.utils.MyData;

/**
 * Servlet implementation class Login
 */
@WebServlet("/FileList")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileList() {
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
	@SuppressWarnings({ "unchecked", "unused" })
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
			String pro_id = request.getParameter("pro_id");
			System.out.println("--FileList--" + user_id);
			
			Transaction transaction=HibernateSessionFactory.getSession().beginTransaction();
			UserDAO userDAO = new UserDAO();
			ProjectDAO projectDAO = new ProjectDAO();
			// 根据id查询
			User user = userDAO.findById(Integer.parseInt(user_id));
			System.out.println("---" + user.getSkey() + "----" + skey);
			if (user != null) {
				// 判断skey
				if (user.getSkey().equals(skey)) {					
					Project project = projectDAO.findById(Integer
							.parseInt(pro_id));
					List<FileEntity> listFile = new ArrayList<FileEntity>();
					for (Folder folder : (Set<Folder>) project.getFolders()) {
						listFile.addAll(getFile(folder));
					}
					// 返回数据
					result.flag = MyData.SUCC;
					result.details = "";
					result.data = JSON.toJSONString(listFile);

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

	@SuppressWarnings("unchecked")
	private List<FileEntity> getFile(Folder folder) {
		List<FileEntity> listFile = new ArrayList<FileEntity>();
		for(File file:(Set<File>) folder.getFiles()){
			listFile.add(new FileEntity(file));
		}
		Set<Folder> setFolder = (Set<Folder>) folder.getFolders();
		if (setFolder != null && !setFolder.isEmpty())
			for (Folder folder1 : setFolder) {
				listFile.addAll(getFile(folder1));
			}
		return listFile;
	}
}
