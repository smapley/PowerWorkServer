package com.smapley.bean;

import java.sql.Timestamp;

/**
 * AbstractFile entity provides the base persistence definition of the File
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFile implements java.io.Serializable {

	// Fields

	private Integer filId;
	private Folder folder;
	private User user;
	private String name;
	private Integer type;
	private String url;
	private Timestamp creDate;

	// Constructors

	/** default constructor */
	public AbstractFile() {
	}

	/** minimal constructor */
	public AbstractFile(Integer filId, User user, String name, Integer type,
			String url) {
		this.filId = filId;
		this.user = user;
		this.name = name;
		this.type = type;
		this.url = url;
	}

	/** full constructor */
	public AbstractFile(Integer filId, Folder folder, User user, String name,
			Integer type, String url, Timestamp creDate) {
		this.filId = filId;
		this.folder = folder;
		this.user = user;
		this.name = name;
		this.type = type;
		this.url = url;
		this.creDate = creDate;
	}

	// Property accessors

	public Integer getFilId() {
		return this.filId;
	}

	public void setFilId(Integer filId) {
		this.filId = filId;
	}

	public Folder getFolder() {
		return this.folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

}