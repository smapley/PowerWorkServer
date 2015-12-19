package com.smapley.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;
import com.smapley.bean.Note;
import com.smapley.bean.NoteDAO;
import com.smapley.bean.NoteDetails;
import com.smapley.bean.NoteDetailsDAO;
import com.smapley.bean.User;
import com.smapley.mode.NoteMode;
import com.smapley.mode.Result;
import com.smapley.utils.MyData;

/**
 * 
 * @author Administrator 文件上传 具体步骤： 1）获得磁盘文件条目工厂 DiskFileItemFactory 要导包 2） 利用
 *         request 获取 真实路径 ，供临时文件存储，和 最终文件存储 ，这两个存储位置可不同，也可相同 3）对
 *         DiskFileItemFactory 对象设置一些 属性 4）高水平的API文件上传处理 ServletFileUpload
 *         upload = new ServletFileUpload(factory); 目的是调用
 *         parseRequest（request）方法 获得 FileItem 集合list ，
 * 
 *         5）在 FileItem 对象中 获取信息， 遍历， 判断 表单提交过来的信息 是否是 普通文本信息 另做处理 6） 第一种. 用第三方
 *         提供的 item.write( new File(path,filename) ); 直接写到磁盘上 第二种. 手动处理
 * 
 */
@WebServlet("/AddNote")
public class AddNote extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NoteDAO noteDAO = NoteDAO
			.getFromApplicationContext(MyData.getCXT());
	private NoteDetailsDAO noteDetailsDAO = NoteDetailsDAO
			.getFromApplicationContext(MyData.getCXT());

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Result result = new Result();

		System.out.println("---AddNote---");

		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		@SuppressWarnings("deprecation")
		String picPath = request.getRealPath("/upload/note/pic");
		@SuppressWarnings("deprecation")
		String voicePath = request.getRealPath("/upload/note/voice");
		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		File picFile = new File(picPath);
		if (!picFile.exists()) {
			picFile.mkdirs();
		}
		File voiceFile = new File(voicePath);
		if (!voiceFile.exists()) {
			voiceFile.mkdirs();
		}
		factory.setRepository(picFile);
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			Map<String, FileItem> map = new HashMap<String, FileItem>();
			for (FileItem item : list) {
				// 获取表单的属性名字
				map.put(item.getFieldName(), item);
			}

			HttpSession session = request.getSession(false);
			if (session != null) {
				User user = (User) session.getAttribute("user");
				// 添加note
				Note note = new Note();
				note.setName(map.get("name").getString("utf-8"));
				note.setUser(user);
				note.setAlarm(new Timestamp(Long.parseLong(map.get("alarm")
						.getString("utf-8"))));
				note.setCreDate(new Timestamp(System.currentTimeMillis()));
				note.setRefresh(new Timestamp(System.currentTimeMillis()));
				note.setState(0);
				noteDAO.save(note);
				for (int i = 0; i < Integer.parseInt(map.get("size").getString(
						"utf-8")); i++) {
					NoteDetails noteDetails = new NoteDetails();
					noteDetails.setNote(note);
					int type = Integer.parseInt(map.get("type" + i).getString(
							"utf-8"));
					noteDetails.setType(type);
					noteDetails.setRefresh(new Timestamp(System
							.currentTimeMillis()));
					noteDetails.setState(0);
					switch (type) {
					case 5:
						if (map.get("text" + i) != null)
							noteDetails.setText(map.get("text" + i).getString(
									"utf-8"));
						break;
					case 4:
						FileItem item = map.get("file" + i);
						/**
						 * 以下三步，主要获取 上传文件的名字
						 */
						// 获取路径名
						String value = item.getName();
						// 索引到最后一个反斜杠
						int start = value.lastIndexOf("\\");
						// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
						String filename = value.substring(start + 1);
						filename = user.getUseId() + "_"
								+ System.currentTimeMillis() + "."
								+ filename.split("\\.")[1];
						// 真正写到磁盘上
						// 它抛出的异常 用exception 捕捉
						item.write(new File(voiceFile, filename));// 第三方提供的
						noteDetails.setPath("voice/" + filename);
						noteDetails.setLength(new Time(Long.parseLong(map.get(
								"length" + i).getString())));
						break;

					case 3:
						FileItem item1 = map.get("file" + i);
						/**
						 * 以下三步，主要获取 上传文件的名字
						 */
						// 获取路径名
						String value1 = item1.getName();
						// 索引到最后一个反斜杠
						int start1 = value1.lastIndexOf("\\");
						// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
						String filename1 = value1.substring(start1 + 1);
						filename1 = user.getUseId() + "_"
								+ System.currentTimeMillis() + "."
								+ filename1.split("\\.")[1];
						// 真正写到磁盘上
						// 它抛出的异常 用exception 捕捉
						item1.write(new File(picPath, filename1));// 第三方提供的
						noteDetails.setPath("pic/" + filename1);
						break;
					}
					noteDetailsDAO.save(noteDetails);
				}
				note = noteDAO.findByExample(note).get(0);
				result.flag = MyData.SUCC;
				result.details = "";
				result.data = JSON.toJSONString(new NoteMode(note, 0));
			} else {
				result.flag = MyData.OutLogin;
				result.details = MyData.ERR_OutLogin;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.details = MyData.ERR_UpLoadFail;
		}

		System.out.println("---AddNote--result--" + result.flag + "--"
				+ result.details + "--" + result.data);
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();

	}

}