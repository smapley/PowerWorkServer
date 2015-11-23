package com.smapley.test;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Transaction;

import com.smapley.HibernateSessionFactory;
import com.smapley.bean.Feedbacks;
import com.smapley.bean.FeedbacksDAO;
import com.smapley.bean.Project;
import com.smapley.bean.ProjectDAO;
import com.smapley.bean.User;
import com.smapley.bean.UserDAO;

public class Test {

	@org.junit.Test
	public void test() {
		fail("Not yet implemented");
	}

	@org.junit.Test
	public void save(){
		
		UserDAO userDAO=new UserDAO();
		ProjectDAO projectDAO=new ProjectDAO();
		Transaction transaction=HibernateSessionFactory.getSession().beginTransaction();
		User user=userDAO.findById(110);
		Project project=new Project();
		project.setName("asdfasdfa");
		project.setUser(user);
		
		projectDAO.save(project);
		transaction.commit();
	}
}
