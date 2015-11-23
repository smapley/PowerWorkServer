package com.smapley.bean;

import java.sql.Timestamp;

/**
 * AbstractTask entity provides the base persistence definition of the Task
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTask implements java.io.Serializable {

	// Fields

	private Integer tasId;
	private User user;
	private Integer proId;
	private String name;
	private String details;
	private Timestamp staDate;
	private Timestamp endDate;
	private Integer progress;
	private Integer appointee;
	private Integer annex;
	private Integer priority;
	private Timestamp creDate;
	private Integer type;

	// Constructors

	/** default constructor */
	public AbstractTask() {
	}

	/** minimal constructor */
	public AbstractTask(Integer tasId, User user, Integer proId) {
		this.tasId = tasId;
		this.user = user;
		this.proId = proId;
	}

	/** full constructor */
	public AbstractTask(Integer tasId, User user, Integer proId, String name,
			String details, Timestamp staDate, Timestamp endDate,
			Integer progress, Integer appointee, Integer annex,
			Integer priority, Timestamp creDate, Integer type) {
		this.tasId = tasId;
		this.user = user;
		this.proId = proId;
		this.name = name;
		this.details = details;
		this.staDate = staDate;
		this.endDate = endDate;
		this.progress = progress;
		this.appointee = appointee;
		this.annex = annex;
		this.priority = priority;
		this.creDate = creDate;
		this.type = type;
	}

	// Property accessors

	public Integer getTasId() {
		return this.tasId;
	}

	public void setTasId(Integer tasId) {
		this.tasId = tasId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Timestamp getStaDate() {
		return this.staDate;
	}

	public void setStaDate(Timestamp staDate) {
		this.staDate = staDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Integer getProgress() {
		return this.progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public Integer getAppointee() {
		return this.appointee;
	}

	public void setAppointee(Integer appointee) {
		this.appointee = appointee;
	}

	public Integer getAnnex() {
		return this.annex;
	}

	public void setAnnex(Integer annex) {
		this.annex = annex;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

}