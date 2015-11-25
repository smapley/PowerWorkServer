package com.smapley.bean;

/**
 * AbstractTasUse entity provides the base persistence definition of the TasUse
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTasUse implements java.io.Serializable {

	// Fields

	private TasUseId id;

	// Constructors

	/** default constructor */
	public AbstractTasUse() {
	}

	/** full constructor */
	public AbstractTasUse(TasUseId id) {
		this.id = id;
	}

	// Property accessors

	public TasUseId getId() {
		return this.id;
	}

	public void setId(TasUseId id) {
		this.id = id;
	}

}