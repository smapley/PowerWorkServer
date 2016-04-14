package com.smapley.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Message", catalog = "PowerWork")
public class Message implements java.io.Serializable {

	// Fields

	private Integer mesId;
	private Project project;
	private User userByUseId;
	private Task task;
	private User userBySrcUseId;
	private Integer type;
	private String details;
	private Timestamp creDate;
	private Timestamp refresh;
	private Integer state;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Project project, User userByUseId, Task task,
			User userBySrcUseId, Integer type, String details,
			Timestamp creDate, Timestamp refresh, Integer state) {
		this.project = project;
		this.userByUseId = userByUseId;
		this.task = task;
		this.userBySrcUseId = userBySrcUseId;
		this.type = type;
		this.details = details;
		this.creDate = creDate;
		this.refresh = refresh;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "mes_id", unique = true, nullable = false)
	public Integer getMesId() {
		return this.mesId;
	}

	public void setMesId(Integer mesId) {
		this.mesId = mesId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "use_id")
	public User getUserByUseId() {
		return this.userByUseId;
	}

	public void setUserByUseId(User userByUseId) {
		this.userByUseId = userByUseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tas_id")
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "src_use_id")
	public User getUserBySrcUseId() {
		return this.userBySrcUseId;
	}

	public void setUserBySrcUseId(User userBySrcUseId) {
		this.userBySrcUseId = userBySrcUseId;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "details")
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
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

}