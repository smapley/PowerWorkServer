package com.smapley.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractFolder entity provides the base persistence definition of the Folder
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFolder implements java.io.Serializable {

	// Fields

	private Integer folId;
	private Project project;
	private Folder folder;
	private User user;
	private String name;
	private Set folders = new HashSet(0);
	private Set files = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractFolder() {
	}

	/** minimal constructor */
	public AbstractFolder(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractFolder(Project project, Folder folder, User user,
			String name, Set folders, Set files) {
		this.project = project;
		this.folder = folder;
		this.user = user;
		this.name = name;
		this.folders = folders;
		this.files = files;
	}

	// Property accessors

	public Integer getFolId() {
		return this.folId;
	}

	public void setFolId(Integer folId) {
		this.folId = folId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public Set getFolders() {
		return this.folders;
	}

	public void setFolders(Set folders) {
		this.folders = folders;
	}

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

}