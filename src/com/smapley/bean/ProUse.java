package com.smapley.bean;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProUse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Pro_Use", catalog = "PowerWork")
public class ProUse implements java.io.Serializable {

	// Fields

	private ProUseId id;
	private Project project;
	private User user;
	private Integer rank;

	// Constructors

	/** default constructor */
	public ProUse() {
	}

	/** full constructor */
	public ProUse(ProUseId id, Project project, User user, Integer rank) {
		this.id = id;
		this.project = project;
		this.user = user;
		this.rank = rank;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "useId", column = @Column(name = "use_id", nullable = false)),
			@AttributeOverride(name = "proId", column = @Column(name = "pro_id", nullable = false)) })
	public ProUseId getId() {
		return this.id;
	}

	public void setId(ProUseId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pro_id", nullable = false, insertable = false, updatable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "use_id", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "rank", nullable = false)
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}