package com.smapley.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TasUseId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TasUseId implements java.io.Serializable {

	// Fields

	private Integer tasId;
	private Integer useId;
	private Integer rank;

	// Constructors

	/** default constructor */
	public TasUseId() {
	}

	/** full constructor */
	public TasUseId(Integer tasId, Integer useId, Integer rank) {
		this.tasId = tasId;
		this.useId = useId;
		this.rank = rank;
	}

	// Property accessors

	@Column(name = "tas_id", nullable = false)
	public Integer getTasId() {
		return this.tasId;
	}

	public void setTasId(Integer tasId) {
		this.tasId = tasId;
	}

	@Column(name = "use_id", nullable = false)
	public Integer getUseId() {
		return this.useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	@Column(name = "rank", nullable = false)
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TasUseId))
			return false;
		TasUseId castOther = (TasUseId) other;

		return ((this.getTasId() == castOther.getTasId()) || (this.getTasId() != null
				&& castOther.getTasId() != null && this.getTasId().equals(
				castOther.getTasId())))
				&& ((this.getUseId() == castOther.getUseId()) || (this
						.getUseId() != null && castOther.getUseId() != null && this
						.getUseId().equals(castOther.getUseId())))
				&& ((this.getRank() == castOther.getRank()) || (this.getRank() != null
						&& castOther.getRank() != null && this.getRank()
						.equals(castOther.getRank())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTasId() == null ? 0 : this.getTasId().hashCode());
		result = 37 * result
				+ (getUseId() == null ? 0 : this.getUseId().hashCode());
		result = 37 * result
				+ (getRank() == null ? 0 : this.getRank().hashCode());
		return result;
	}

}