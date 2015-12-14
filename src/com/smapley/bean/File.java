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
 * File entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "File", catalog = "PowerWork")
public class File implements java.io.Serializable {

	// Fields

	private Integer filId;
	private Folder folder;
	private User user;
	private String name;
	private Integer type;
	private String url;
	private Timestamp creDate;
	private Set<Dynamic> dynamics = new HashSet<Dynamic>(0);

	// Constructors

	/** default constructor */
	public File() {
	}

	/** minimal constructor */
	public File(User user, String name, Integer type, String url) {
		this.user = user;
		this.name = name;
		this.type = type;
		this.url = url;
	}

	/** full constructor */
	public File(Folder folder, User user, String name, Integer type,
			String url, Timestamp creDate, Set<Dynamic> dynamics) {
		this.folder = folder;
		this.user = user;
		this.name = name;
		this.type = type;
		this.url = url;
		this.creDate = creDate;
		this.dynamics = dynamics;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "fil_id", unique = true, nullable = false)
	public Integer getFilId() {
		return this.filId;
	}

	public void setFilId(Integer filId) {
		this.filId = filId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fol_id")
	public Folder getFolder() {
		return this.folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "use_id", nullable = false)
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

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "url", nullable = false)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "cre_date", length = 19)
	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "file")
	public Set<Dynamic> getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(Set<Dynamic> dynamics) {
		this.dynamics = dynamics;
	}

}