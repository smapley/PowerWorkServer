package com.smapley.bean;

import java.sql.Timestamp;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password) {
		super(username, password);
	}

	/** full constructor */
	public User(String username, String password, String nickname,
			String truename, String picUrl, String phone, Timestamp birthday,
			Timestamp creDate, String skey, Set projects, Set folders,
			Set tasUses, Set tasks, Set feedbackses, Set files, Set proUses) {
		super(username, password, nickname, truename, picUrl, phone, birthday,
				creDate, skey, projects, folders, tasUses, tasks, feedbackses,
				files, proUses);
	}

}
