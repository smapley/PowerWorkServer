package com.smapley.bean;

/**
 * AbstractPraise entity provides the base persistence definition of the Praise
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPraise implements java.io.Serializable {

	// Fields

	private Integer praId;
	private Dynamic dynamic;
	private User user;

	// Constructors

	/** default constructor */
	public AbstractPraise() {
	}

	/** full constructor */
	public AbstractPraise(Dynamic dynamic, User user) {
		this.dynamic = dynamic;
		this.user = user;
	}

	// Property accessors

	public Integer getPraId() {
		return this.praId;
	}

	public void setPraId(Integer praId) {
		this.praId = praId;
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

}