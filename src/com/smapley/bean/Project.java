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
	public Project(String name, String picUrl, Timestamp creDate, Set tasks,
			Set folders, Set proUses, Set dynamics) {
		super(name, picUrl, creDate, tasks, folders, proUses, dynamics);
	}

}
