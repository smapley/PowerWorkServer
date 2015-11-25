package com.smapley.bean;

/**
 * AbstractTasUseId entity provides the base persistence definition of the
 * TasUseId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTasUseId implements java.io.Serializable {

	// Fields

	private Task task;
	private User user;

	// Constructors

	/** default constructor */
	public AbstractTasUseId() {
	}

	/** full constructor */
	public AbstractTasUseId(Task task, User user) {
		this.task = task;
		this.user = user;
	}

	// Property accessors

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractTasUseId))
			return false;
		AbstractTasUseId castOther = (AbstractTasUseId) other;

		return ((this.getTask() == castOther.getTask()) || (this.getTask() != null
				&& castOther.getTask() != null && this.getTask().equals(
				castOther.getTask())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTask() == null ? 0 : this.getTask().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		return result;
	}

}