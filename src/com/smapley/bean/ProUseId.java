package com.smapley.bean;

/**
 * ProUseId entity. @author MyEclipse Persistence Tools
 */
public class ProUseId extends AbstractProUseId implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ProUseId() {
	}

	/** full constructor */
	public ProUseId(User user, Project project) {
		super(user, project);
	}

}
