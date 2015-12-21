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
 * Dynamic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Dynamic", catalog = "PowerWork")
public class Dynamic implements java.io.Serializable {

	// Fields

	private Integer dynId;
	private Project project;
	private User user;
	private Task task;
	private File file;
	private Timestamp creDate;
	private Integer type;
	private String picUrl;
	private Timestamp refresh;
	private Integer state;
	private Set<Praise> praises = new HashSet<Praise>(0);
	private Set<Discuss> discusses = new HashSet<Discuss>(0);

	// Constructors

	/** default constructor */
	public Dynamic() {
	}

	/** full constructor */
	public Dynamic(Project project, User user, Task task, File file,
			Timestamp creDate, Integer type, String picUrl, Timestamp refresh,
			Integer state, Set<Praise> praises, Set<Discuss> discusses) {
		this.project = project;
		this.user = user;
		this.task = task;
		this.file = file;
		this.creDate = creDate;
		this.type = type;
		this.picUrl = picUrl;
		this.refresh = refresh;
		this.state = state;
		this.praises = praises;
		this.discusses = discusses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "dyn_id", unique = true, nullable = false)
	public Integer getDynId() {
		return this.dynId;
	}

	public void setDynId(Integer dynId) {
		this.dynId = dynId;
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
	@JoinColumn(name = "use_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tas_id")
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fil_id")
	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Column(name = "cre_date", length = 19)
	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "pic_url")
	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dynamic")
	public Set<Praise> getPraises() {
		return this.praises;
	}

	public void setPraises(Set<Praise> praises) {
		this.praises = praises;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dynamic")
	public Set<Discuss> getDiscusses() {
		return this.discusses;
	}

	public void setDiscusses(Set<Discuss> discusses) {
		this.discusses = discusses;
	}

}