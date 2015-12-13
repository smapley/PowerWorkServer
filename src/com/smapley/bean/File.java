package com.smapley.bean;

import java.sql.Timestamp;
import java.util.Set;

/**
 * File entity. @author MyEclipse Persistence Tools
 */
public class File extends AbstractFile implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public File() {
	}

	/** minimal constructor */
	public File(User user, String name, Integer type, String url) {
		super(user, name, type, url);
	}

	/** full constructor */
	public File(Folder folder, User user, String name, Integer type,
			String url, Timestamp creDate, Set dynamics) {
		super(folder, user, name, type, url, creDate, dynamics);
	}

}
