package com.smapley.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smapley.bean.ProUse;
import com.smapley.bean.ProUseDAO;
import com.smapley.bean.Task;
import com.smapley.bean.TaskDAO;
import com.smapley.bean.User;
import com.smapley.bean.UserDAO;
import com.smapley.utils.MyData;

public class Test {

	public static UserDAO userDAO;
	public static TaskDAO taskDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext cxt = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		userDAO = (UserDAO) cxt.getBean("UserDAO");
		taskDao = TaskDAO.getFromApplicationContext(cxt);
	}

	@org.junit.Test
	public void test() {
		fail("Not yet implemented");
	}

	@org.junit.Test
	public void save() {
	}
}
