package com.smapley.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TasUse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tas_Use", catalog = "PowerWork")
public class TasUse implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Task task;
	private Integer rank;
	private Timestamp refresh;
	private Integer state;

	// Constructors

	/** default constructor */
	public TasUse() {
	}

	/** minimal constructor */
	public TasUse(User user, Task task, Integer rank) {
		this.user = user;
		this.task = task;
		this.rank = rank;
	}

	/** full constructor */
	public TasUse(User user, Task task, Integer rank, Timestamp refresh,
			Integer state) {
		this.user = user;
		this.task = task;
		this.rank = rank;
		this.refresh = refresh;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "use_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tas_id", nullable = false)
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Column(name = "rank", nullable = false)
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
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

}