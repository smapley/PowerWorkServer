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
 * Feedbacks entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Feedbacks", catalog = "PowerWork")
public class Feedbacks implements java.io.Serializable {

	// Fields

	private Integer feeId;
	private User user;
	private String details;
	private Timestamp creDate;
	private Timestamp refresh;
	private Integer state;

	// Constructors

	/** default constructor */
	public Feedbacks() {
	}

	/** minimal constructor */
	public Feedbacks(User user, String details) {
		this.user = user;
		this.details = details;
	}

	/** full constructor */
	public Feedbacks(User user, String details, Timestamp creDate,
			Timestamp refresh, Integer state) {
		this.user = user;
		this.details = details;
		this.creDate = creDate;
		this.refresh = refresh;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "fee_id", unique = true, nullable = false)
	public Integer getFeeId() {
		return this.feeId;
	}

	public void setFeeId(Integer feeId) {
		this.feeId = feeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "use_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "details", nullable = false)
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
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

}