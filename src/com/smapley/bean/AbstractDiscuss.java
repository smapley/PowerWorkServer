package com.smapley.bean;

/**
 * AbstractDiscuss entity provides the base persistence definition of the
 * Discuss entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDiscuss implements java.io.Serializable {

	// Fields

	private Integer disId;
	private Dynamic dynamic;
	private User user;
	private String details;

	// Constructors

	/** default constructor */
	public AbstractDiscuss() {
	}

	/** full constructor */
	public AbstractDiscuss(Dynamic dynamic, User user, String details) {
		this.dynamic = dynamic;
		this.user = user;
		this.details = details;
	}

	// Property accessors

	public Integer getDisId() {
		return this.disId;
	}

	public void setDisId(Integer disId) {
		this.disId = disId;
	}

	public Dynamic getDynamic() {
		return this.dynamic;
	}

	public void setDynamic(Dynamic dynamic) {
		this.dynamic = dynamic;
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

}