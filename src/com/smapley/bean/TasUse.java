package com.smapley.bean;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TasUse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tas_Use", catalog = "PowerWork")
public class TasUse implements java.io.Serializable {

	// Fields

	private TasUseId id;
	private User user;
	private Task task;
	private Timestamp refresh;
	private Integer state;

	// Constructors

	/** default constructor */
	public TasUse() {
	}

	/** minimal constructor */
	public TasUse(TasUseId id, User user, Task task) {
		this.id = id;
		this.user = user;
		this.task = task;
	}

	/** full constructor */
	public TasUse(TasUseId id, User user, Task task, Timestamp refresh,
			Integer state) {
		this.id = id;
		this.user = user;
		this.task = task;
		this.refresh = refresh;
		this.state = state;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tasId", column = @Column(name = "tas_id", nullable = false)),
			@AttributeOverride(name = "useId", column = @Column(name = "use_id", nullable = false)),
			@AttributeOverride(name = "rank", column = @Column(name = "rank", nullable = false)) })
	public TasUseId getId() {
		return this.id;
	}

	public void setId(TasUseId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "use_id", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tas_id", nullable = false, insertable = false, updatable = false)
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
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