package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractProject entity provides the base persistence definition of the
 * Project entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProject implements java.io.Serializable {

	// Fields

	private Integer proId;
	private String name;
	private String picUrl;
	private Timestamp creDate;
	private Set tasks = new HashSet(0);
	private Set folders = new HashSet(0);
	private Set proUses = new HashSet(0);
	private Set dynamics = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractProject() {
	}

	/** full constructor */
	public AbstractProject(String name, String picUrl, Timestamp creDate,
			Set tasks, Set folders, Set proUses, Set dynamics) {
		this.name = name;
		this.picUrl = picUrl;
		this.creDate = creDate;
		this.tasks = tasks;
		this.folders = folders;
		this.proUses = proUses;
		this.dynamics = dynamics;
	}

	// Property accessors

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	public Set getTasks() {
		return this.tasks;
	}

	public void setTasks(Set tasks) {
		this.tasks = tasks;
	}

	public Set getFolders() {
		return this.folders;
	}

	public void setFolders(Set folders) {
		this.folders = folders;
	}

	public Set getProUses() {
		return this.proUses;
	}

	public void setProUses(Set proUses) {
		this.proUses = proUses;
	}

	public Set getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(Set dynamics) {
		this.dynamics = dynamics;
	}

}