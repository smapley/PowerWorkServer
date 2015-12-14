package com.smapley.bean;

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

	// Constructors

	/** default constructor */
	public TasUse() {
	}

	/** full constructor */
	public TasUse(TasUseId id, User user, Task task) {
		this.id = id;
		this.user = user;
		this.task = task;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tas_id", nullable = false, insertable = false, updatable = false)
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}