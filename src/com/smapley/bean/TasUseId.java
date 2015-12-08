package com.smapley.bean;

/**
 * TasUseId entity. @author MyEclipse Persistence Tools
 */
public class TasUseId extends AbstractTasUseId implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TasUseId() {
	}

	/** full constructor */
	public TasUseId(Task task, User user, Integer rank) {
		super(task, user, rank);
	}

}
