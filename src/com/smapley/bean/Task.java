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
	public Task(Project project) {
		super(project);
	}

	/** full constructor */
	public Task(Project project, String name, Timestamp staDate,
			Timestamp endDate, Integer progress, Integer priority,
			Timestamp creDate, Set taskDetailses, Set tasUses, Set dynamics) {
		super(project, name, staDate, endDate, progress, priority, creDate,
				taskDetailses, tasUses, dynamics);
	}

}
