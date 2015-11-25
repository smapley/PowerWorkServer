package com.smapley.bean;

import java.util.Set;

/**
 * Folder entity. @author MyEclipse Persistence Tools
 */
public class Folder extends AbstractFolder implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Folder() {
	}

	/** minimal constructor */
	public Folder(String name) {
		super(name);
	}

	/** full constructor */
	public Folder(Project project, Folder folder, User user, String name,
			Set folders, Set files) {
		super(project, folder, user, name, folders, files);
	}

}
