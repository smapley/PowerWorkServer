package com.smapley.bean;

/**
 * AbstractTasUseId entity provides the base persistence definition of the
 * TasUseId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTasUseId implements java.io.Serializable {

	// Fields

	private Task task;
	private User user;
	private Integer rank;

	// Constructors

	/** default constructor */
	public AbstractTasUseId() {
	}

	/** full constructor */
	public AbstractTasUseId(Task task, User user, Integer rank) {
		this.task = task;
		this.user = user;
		this.rank = rank;
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

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
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
						.equals(castOther.getUser())))
				&& ((this.getRank() == castOther.getRank()) || (this.getRank() != null
						&& castOther.getRank() != null && this.getRank()
						.equals(castOther.getRank())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTask() == null ? 0 : this.getTask().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getRank() == null ? 0 : this.getRank().hashCode());
		return result;
	}

}