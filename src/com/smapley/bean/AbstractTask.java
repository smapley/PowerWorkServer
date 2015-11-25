package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTask entity provides the base persistence definition of the Task
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTask implements java.io.Serializable {

	// Fields

	private Integer tasId;
	private Project project;
	private User user;
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
	private Set tasUses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTask() {
	}

	/** minimal constructor */
	public AbstractTask(Integer tasId, Project project, User user) {
		this.tasId = tasId;
		this.project = project;
		this.user = user;
	}

	/** full constructor */
	public AbstractTask(Integer tasId, Project project, User user, String name,
			String details, Timestamp staDate, Timestamp endDate,
			Integer progress, Integer appointee, Integer annex,
			Integer priority, Timestamp creDate, Integer type, Set tasUses) {
		this.tasId = tasId;
		this.project = project;
		this.user = user;
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
		this.tasUses = tasUses;
	}

	// Property accessors

	public Integer getTasId() {
		return this.tasId;
	}

	public void setTasId(Integer tasId) {
		this.tasId = tasId;
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

	public Set getTasUses() {
		return this.tasUses;
	}

	public void setTasUses(Set tasUses) {
		this.tasUses = tasUses;
	}

}