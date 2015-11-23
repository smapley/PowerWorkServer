package com.smapley.bean;

/**
 * AbstractProUse entity provides the base persistence definition of the ProUse
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProUse implements java.io.Serializable {

	// Fields

	private ProUseId id;
	private Integer rank;

	// Constructors

	/** default constructor */
	public AbstractProUse() {
	}

	/** full constructor */
	public AbstractProUse(ProUseId id, Integer rank) {
		this.id = id;
		this.rank = rank;
	}

	// Property accessors

	public ProUseId getId() {
		return this.id;
	}

	public void setId(ProUseId id) {
		this.id = id;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}