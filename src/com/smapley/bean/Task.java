package com.smapley.bean;

import java.sql.Timestamp;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
public class Task extends AbstractTask implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(Integer tasId, User user, Integer proId) {
		super(tasId, user, proId);
	}

	/** full constructor */
	public Task(Integer tasId, User user, Integer proId, String name,
			String details, Timestamp staDate, Timestamp endDate,
			Integer progress, Integer appointee, Integer annex,
			Integer priority, Timestamp creDate, Integer type) {
		super(tasId, user, proId, name, details, staDate, endDate, progress,
				appointee, annex, priority, creDate, type);
	}

}
