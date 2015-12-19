package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Folder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Folder", catalog = "PowerWork")
public class Folder implements java.io.Serializable {

	// Fields

	private Integer folId;
	private Project project;
	private Folder folder;
	private User user;
	private String name;
	private Timestamp refresh;
	private Integer state;
	private Set<Folder> folders = new HashSet<Folder>(0);
	private Set<File> files = new HashSet<File>(0);

	// Constructors

	/** default constructor */
	public Folder() {
	}

	/** minimal constructor */
	public Folder(String name) {
		this.name = name;
	}

	/** full constructor */
	public Folder(Project project, Folder folder, User user, String name,
			Timestamp refresh, Integer state, Set<Folder> folders,
			Set<File> files) {
		this.project = project;
		this.folder = folder;
		this.user = user;
		this.name = name;
		this.refresh = refresh;
		this.state = state;
		this.folders = folders;
		this.files = files;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "fol_id", unique = true, nullable = false)
	public Integer getFolId() {
		return this.folId;
	}

	public void setFolId(Integer folId) {
		this.folId = folId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fol_id2")
	public Folder getFolder() {
		return this.folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "use_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "refresh", length = 19)
	public Timestamp getRefresh() {
		return this.refresh;
	}

	public void setRefresh(Timestamp refresh) {
		this.refresh = refresh;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "folder")
	public Set<Folder> getFolders() {
		return this.folders;
	}

	public void setFolders(Set<Folder> folders) {
		this.folders = folders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "folder")
	public Set<File> getFiles() {
		return this.files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}

}