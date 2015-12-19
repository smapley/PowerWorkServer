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
 * Discuss entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Discuss", catalog = "PowerWork")
public class Discuss implements java.io.Serializable {

	// Fields

	private Integer disId;
	private Dynamic dynamic;
	private User user;
	private String details;
	private Timestamp refresh;
	private Integer state;

	// Constructors

	/** default constructor */
	public Discuss() {
	}

	/** full constructor */
	public Discuss(Dynamic dynamic, User user, String details,
			Timestamp refresh, Integer state) {
		this.dynamic = dynamic;
		this.user = user;
		this.details = details;
		this.refresh = refresh;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "dis_id", unique = true, nullable = false)
	public Integer getDisId() {
		return this.disId;
	}

	public void setDisId(Integer disId) {
		this.disId = disId;
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

	@Column(name = "details")
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
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