package com.smapley.bean;

import java.sql.Time;

/**
 * AbstractTaskDetails entity provides the base persistence definition of the
 * TaskDetails entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTaskDetails implements java.io.Serializable {

	// Fields

	private Integer detId;
	private Task task;
	private Integer type;
	private String text;
	private String path;
	private Time length;

	// Constructors

	/** default constructor */
	public AbstractTaskDetails() {
	}

	/** full constructor */
	public AbstractTaskDetails(Task task, Integer type, String text,
			String path, Time length) {
		this.task = task;
		this.type = type;
		this.text = text;
		this.path = path;
		this.length = length;
	}

	// Property accessors

	public Integer getDetId() {
		return this.detId;
	}

	public void setDetId(Integer detId) {
		this.detId = detId;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Time getLength() {
		return this.length;
	}

	public void setLength(Time length) {
		this.length = length;
	}

}