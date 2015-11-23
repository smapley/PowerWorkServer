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
	private User user;
	private String name;
	private String picUrl;
	private Timestamp creDate;
	private Set files = new HashSet(0);
	private Set proUses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractProject() {
	}

	/** full constructor */
	public AbstractProject(User user, String name, String picUrl,
			Timestamp creDate, Set files, Set proUses) {
		this.user = user;
		this.name = name;
		this.picUrl = picUrl;
		this.creDate = creDate;
		this.files = files;
		this.proUses = proUses;
	}

	// Property accessors

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

	public Set getProUses() {
		return this.proUses;
	}

	public void setProUses(Set proUses) {
		this.proUses = proUses;
	}

}