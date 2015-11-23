package com.smapley.bean;

import java.sql.Timestamp;

/**
 * Feedbacks entity. @author MyEclipse Persistence Tools
 */
public class Feedbacks extends AbstractFeedbacks implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Feedbacks() {
	}

	/** minimal constructor */
	public Feedbacks(User user, String details) {
		super(user, details);
	}

	/** full constructor */
	public Feedbacks(User user, String details, Timestamp creDate) {
		super(user, details, creDate);
	}

}
