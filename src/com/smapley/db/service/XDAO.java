package com.smapley.db.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smapley.bean.DiscussDAO;
import com.smapley.bean.DynamicDAO;
import com.smapley.bean.FeedbacksDAO;
import com.smapley.bean.FileDAO;
import com.smapley.bean.FolderDAO;
import com.smapley.bean.MessageDAO;
import com.smapley.bean.NoteDAO;
import com.smapley.bean.NoteDetailsDAO;
import com.smapley.bean.PraiseDAO;
import com.smapley.bean.ProUseDAO;
import com.smapley.bean.ProjectDAO;
import com.smapley.bean.TasUseDAO;
import com.smapley.bean.TaskDAO;
import com.smapley.bean.TaskDetailsDAO;
import com.smapley.bean.UserBaseDAO;
import com.smapley.bean.UserDAO;

public class XDAO {

	public static UserDAO userDAO = UserDAO.getFromApplicationContext(getCXT());
	public static DiscussDAO discussDAO = DiscussDAO
			.getFromApplicationContext(getCXT());
	public static DynamicDAO dynamicDAO = DynamicDAO
			.getFromApplicationContext(getCXT());
	public static FeedbacksDAO feedbacksDAO = FeedbacksDAO
			.getFromApplicationContext(getCXT());
	public static FileDAO fileDAO = FileDAO.getFromApplicationContext(getCXT());
	public static FolderDAO folderDAO = FolderDAO
			.getFromApplicationContext(getCXT());
	public static MessageDAO messageDAO = MessageDAO
			.getFromApplicationContext(getCXT());
	public static NoteDAO noteDAO = NoteDAO.getFromApplicationContext(getCXT());
	public static NoteDetailsDAO noteDetailsDAO = NoteDetailsDAO
			.getFromApplicationContext(getCXT());
	public static PraiseDAO praiseDAO = PraiseDAO
			.getFromApplicationContext(getCXT());
	public static ProjectDAO projectDAO = ProjectDAO
			.getFromApplicationContext(getCXT());
	public static ProUseDAO proUseDAO = ProUseDAO
			.getFromApplicationContext(getCXT());
	public static TaskDAO taskDAO = TaskDAO.getFromApplicationContext(getCXT());
	public static TaskDetailsDAO taskDetailsDAO = TaskDetailsDAO
			.getFromApplicationContext(getCXT());
	public static TasUseDAO tasUseDAO = TasUseDAO
			.getFromApplicationContext(getCXT());
	public static UserBaseDAO userBaseDAO = UserBaseDAO
			.getFromApplicationContext(getCXT());

	public static ApplicationContext cxt;

	public static ApplicationContext getCXT() {
		if (cxt == null)
			cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		return cxt;
	}
}
