package com.smapley.test;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smapley.bean.Task;
import com.smapley.bean.User;
import com.smapley.dao.TaskDAO;
import com.smapley.dao.UserDAO;

public class Test {

	public static UserDAO userDAO;
	public static TaskDAO taskDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContext.xml");
		userDAO=(UserDAO)cxt.getBean("UserDAO");
		taskDao=TaskDAO.getFromApplicationContext(cxt);
	}

	
	@org.junit.Test
	public void test() {
		fail("Not yet implemented");
	}

	@org.junit.Test
	public void save(){
		Task task=taskDao.findById(30);
		System.out.println(task.getName());
		System.out.println(task.getProject().getName());
	}
}
