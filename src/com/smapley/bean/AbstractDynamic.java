package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractDynamic entity provides the base persistence definition of the
 * Dynamic entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDynamic implements java.io.Serializable {

	// Fields

	private Integer dynId;
	private Project project;
	private User user;
	private Task task;
	private Timestamp creDate;
	private Integer type;
	private String picUrl;
	private Set praises = new HashSet(0);
	private Set discusses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractDynamic() {
	}

	/** full constructor */
	public AbstractDynamic(Project project, User user, Task task,
			Timestamp creDate, Integer type, String picUrl, Set praises,
			Set discusses) {
		this.project = project;
		this.user = user;
		this.task = task;
		this.creDate = creDate;
		this.type = type;
		this.picUrl = picUrl;
		this.praises = praises;
		this.discusses = discusses;
	}

	// Property accessors

	public Integer getDynId() {
		return this.dynId;
	}

	public void setDynId(Integer dynId) {
		this.dynId = dynId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Set getPraises() {
		return this.praises;
	}

	public void setPraises(Set praises) {
		this.praises = praises;
	}

	public Set getDiscusses() {
		return this.discusses;
	}

	public void setDiscusses(Set discusses) {
		this.discusses = discusses;
	}

}