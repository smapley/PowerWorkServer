package com.smapley.bean;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
public class Task extends AbstractTask implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(Integer tasId, Project project, User user) {
		super(tasId, project, user);
	}

	/** full constructor */
	public Task(Integer tasId, Project project, User user, String name,
			String details, Timestamp staDate, Timestamp endDate,
			Integer progress, Integer appointee, Integer annex,
			Integer priority, Timestamp creDate, Integer type, Set tasUses) {
		super(tasId, project, user, name, details, staDate, endDate, progress,
				appointee, annex, priority, creDate, type, tasUses);
	}

}
