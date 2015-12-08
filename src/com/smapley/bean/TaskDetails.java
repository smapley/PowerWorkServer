package com.smapley.bean;

import java.sql.Time;

/**
 * TaskDetails entity. @author MyEclipse Persistence Tools
 */
public class TaskDetails extends AbstractTaskDetails implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TaskDetails() {
	}

	/** full constructor */
	public TaskDetails(Task task, Integer type, String text, String path,
			Time length) {
		super(task, type, text, path, length);
	}

}
