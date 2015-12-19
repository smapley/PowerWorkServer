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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Project", catalog = "PowerWork")
public class Project implements java.io.Serializable {

	// Fields

	private Integer proId;
	private String name;
	private String picUrl;
	private Timestamp creDate;
	private Timestamp refresh;
	private Integer state;
	private Set<Task> tasks = new HashSet<Task>(0);
	private Set<Folder> folders = new HashSet<Folder>(0);
	private Set<ProUse> proUses = new HashSet<ProUse>(0);
	private Set<Dynamic> dynamics = new HashSet<Dynamic>(0);

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** full constructor */
	public Project(String name, String picUrl, Timestamp creDate,
			Timestamp refresh, Integer state, Set<Task> tasks,
			Set<Folder> folders, Set<ProUse> proUses, Set<Dynamic> dynamics) {
		this.name = name;
		this.picUrl = picUrl;
		this.creDate = creDate;
		this.refresh = refresh;
		this.state = state;
		this.tasks = tasks;
		this.folders = folders;
		this.proUses = proUses;
		this.dynamics = dynamics;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pro_id", unique = true, nullable = false)
	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pic_url")
	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Column(name = "cre_date", length = 19)
	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
	public Set<Folder> getFolders() {
		return this.folders;
	}

	public void setFolders(Set<Folder> folders) {
		this.folders = folders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
	public Set<ProUse> getProUses() {
		return this.proUses;
	}

	public void setProUses(Set<ProUse> proUses) {
		this.proUses = proUses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
	public Set<Dynamic> getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(Set<Dynamic> dynamics) {
		this.dynamics = dynamics;
	}

}