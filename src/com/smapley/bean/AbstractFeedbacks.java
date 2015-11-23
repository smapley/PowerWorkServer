package com.smapley.bean;

import java.sql.Timestamp;

/**
 * AbstractFeedbacks entity provides the base persistence definition of the
 * Feedbacks entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFeedbacks implements java.io.Serializable {

	// Fields

	private Integer feeId;
	private User user;
	private String details;
	private Timestamp creDate;

	// Constructors

	/** default constructor */
	public AbstractFeedbacks() {
	}

	/** minimal constructor */
	public AbstractFeedbacks(User user, String details) {
		this.user = user;
		this.details = details;
	}

	/** full constructor */
	public AbstractFeedbacks(User user, String details, Timestamp creDate) {
		this.user = user;
		this.details = details;
		this.creDate = creDate;
	}

	// Property accessors

	public Integer getFeeId() {
		return this.feeId;
	}

	public void setFeeId(Integer feeId) {
		this.feeId = feeId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

}