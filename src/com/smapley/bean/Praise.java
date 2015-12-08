package com.smapley.bean;

/**
 * Praise entity. @author MyEclipse Persistence Tools
 */
public class Praise extends AbstractPraise implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Praise() {
	}

	/** full constructor */
	public Praise(Dynamic dynamic, User user) {
		super(dynamic, user);
	}

}
