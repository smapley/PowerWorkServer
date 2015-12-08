package com.smapley.bean;

/**
 * Discuss entity. @author MyEclipse Persistence Tools
 */
public class Discuss extends AbstractDiscuss implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Discuss() {
	}

	/** full constructor */
	public Discuss(Dynamic dynamic, User user, String details) {
		super(dynamic, user, details);
	}

}
