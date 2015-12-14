package com.smapley.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProUseId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ProUseId implements java.io.Serializable {

	// Fields

	private Integer useId;
	private Integer proId;

	// Constructors

	/** default constructor */
	public ProUseId() {
	}

	/** full constructor */
	public ProUseId(Integer useId, Integer proId) {
		this.useId = useId;
		this.proId = proId;
	}

	// Property accessors

	@Column(name = "use_id", nullable = false)
	public Integer getUseId() {
		return this.useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	@Column(name = "pro_id", nullable = false)
	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProUseId))
			return false;
		ProUseId castOther = (ProUseId) other;

		return ((this.getUseId() == castOther.getUseId()) || (this.getUseId() != null
				&& castOther.getUseId() != null && this.getUseId().equals(
				castOther.getUseId())))
				&& ((this.getProId() == castOther.getProId()) || (this
						.getProId() != null && castOther.getProId() != null && this
						.getProId().equals(castOther.getProId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUseId() == null ? 0 : this.getUseId().hashCode());
		result = 37 * result
				+ (getProId() == null ? 0 : this.getProId().hashCode());
		return result;
	}

}