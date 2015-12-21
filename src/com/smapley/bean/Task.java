package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Task", catalog = "PowerWork")
public class Task implements java.io.Serializable {

	// Fields

	private Integer tasId;
	private Project project;
	private String name;
	private Timestamp staDate;
	private Timestamp endDate;
	private Integer progress;
	private Integer priority;
	private Timestamp creDate;
	private Timestamp refresh;
	private Integer state;
	private Set<TaskDetails> taskDetailses = new HashSet<TaskDetails>(0);
	private Set<Message> messages = new HashSet<Message>(0);
	private Set<TasUse> tasUses = new HashSet<TasUse>(0);
	private Set<Dynamic> dynamics = new HashSet<Dynamic>(0);

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(Project project) {
		this.project = project;
	}

	/** full constructor */
	public Task(Project project, String name, Timestamp staDate,
			Timestamp endDate, Integer progress, Integer priority,
			Timestamp creDate, Timestamp refresh, Integer state,
			Set<TaskDetails> taskDetailses, Set<Message> messages,
			Set<TasUse> tasUses, Set<Dynamic> dynamics) {
		this.project = project;
		this.name = name;
		this.staDate = staDate;
		this.endDate = endDate;
		this.progress = progress;
		this.priority = priority;
		this.creDate = creDate;
		this.refresh = refresh;
		this.state = state;
		this.taskDetailses = taskDetailses;
		this.messages = messages;
		this.tasUses = tasUses;
		this.dynamics = dynamics;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tas_id", unique = true, nullable = false)
	public Integer getTasId() {
		return this.tasId;
	}

	public void setTasId(Integer tasId) {
		this.tasId = tasId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sta_date", length = 19)
	public Timestamp getStaDate() {
		return this.staDate;
	}

	public void setStaDate(Timestamp staDate) {
		this.staDate = staDate;
	}

	@Column(name = "end_date", length = 19)
	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	@Column(name = "progress")
	public Integer getProgress() {
		return this.progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	@Column(name = "priority")
	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "cre_date", length = 19)
	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	@Column(name = "refresh", length = 19)
	public Timestamp getRefresh() {
		return this.refresh;
	}

	public void setRefresh(Timestamp refresh) {
		this.refresh = refresh;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
	public Set<TaskDetails> getTaskDetailses() {
		return this.taskDetailses;
	}

	public void setTaskDetailses(Set<TaskDetails> taskDetailses) {
		this.taskDetailses = taskDetailses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
	public Set<TasUse> getTasUses() {
		return this.tasUses;
	}

	public void setTasUses(Set<TasUse> tasUses) {
		this.tasUses = tasUses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
	public Set<Dynamic> getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(Set<Dynamic> dynamics) {
		this.dynamics = dynamics;
	}

}