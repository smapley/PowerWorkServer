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
 * Praise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Praise", catalog = "PowerWork")
public class Praise implements java.io.Serializable {

	// Fields

	private Integer praId;
	private Dynamic dynamic;
	private User user;
	private Timestamp refresh;
	private Integer state;

	// Constructors

	/** default constructor */
	public Praise() {
	}

	/** full constructor */
	public Praise(Dynamic dynamic, User user, Timestamp refresh, Integer state) {
		this.dynamic = dynamic;
		this.user = user;
		this.refresh = refresh;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pra_id", unique = true, nullable = false)
	public Integer getPraId() {
		return this.praId;
	}

	public void setPraId(Integer praId) {
		this.praId = praId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dyn_id")
	public Dynamic getDynamic() {
		return this.dynamic;
	}

	public void setDynamic(Dynamic dynamic) {
		this.dynamic = dynamic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "use_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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