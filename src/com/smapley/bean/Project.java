package com.smapley.bean;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */
public class Project extends AbstractProject implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** full constructor */
	public Project(User user, String name, String picUrl, Timestamp creDate,
			Integer total, Set tasks, Set folders, Set proUses) {
		super(user, name, picUrl, creDate, total, tasks, folders, proUses);
	}

}
