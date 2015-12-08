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
	private String name;
	private Timestamp staDate;
	private Timestamp endDate;
	private Integer progress;
	private Integer priority;
	private Timestamp creDate;
	private Set taskDetailses = new HashSet(0);
	private Set tasUses = new HashSet(0);
	private Set dynamics = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTask() {
	}

	/** minimal constructor */
	public AbstractTask(Project project) {
		this.project = project;
	}

	/** full constructor */
	public AbstractTask(Project project, String name, Timestamp staDate,
			Timestamp endDate, Integer progress, Integer priority,
			Timestamp creDate, Set taskDetailses, Set tasUses, Set dynamics) {
		this.project = project;
		this.name = name;
		this.staDate = staDate;
		this.endDate = endDate;
		this.progress = progress;
		this.priority = priority;
		this.creDate = creDate;
		this.taskDetailses = taskDetailses;
		this.tasUses = tasUses;
		this.dynamics = dynamics;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set getTaskDetailses() {
		return this.taskDetailses;
	}

	public void setTaskDetailses(Set taskDetailses) {
		this.taskDetailses = taskDetailses;
	}

	public Set getTasUses() {
		return this.tasUses;
	}

	public void setTasUses(Set tasUses) {
		this.tasUses = tasUses;
	}

	public Set getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(Set dynamics) {
		this.dynamics = dynamics;
	}

}