package com.smapley.bean;

import java.sql.Timestamp;

/**
 * File entity. @author MyEclipse Persistence Tools
 */
public class File extends AbstractFile implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public File() {
	}

	/** minimal constructor */
	public File(Integer filId, User user, String name, Integer type, String url) {
		super(filId, user, name, type, url);
	}

	/** full constructor */
	public File(Integer filId, Folder folder, User user, String name,
			Integer type, String url, Timestamp creDate) {
		super(filId, folder, user, name, type, url, creDate);
	}

}
