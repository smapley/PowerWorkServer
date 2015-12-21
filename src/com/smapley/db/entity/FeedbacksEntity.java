package com.smapley.db.entity;

import com.smapley.bean.Feedbacks;

public class FeedbacksEntity {

	private int fee_id;
	private int use_id;
	private String details;
	private long cre_date;
	private long refresh;
	private int state;

	public FeedbacksEntity(Feedbacks feedbacks) {
		fee_id = feedbacks.getFeeId();
		use_id = feedbacks.getUser().getUseId();
		details = feedbacks.getDetails();
		cre_date = feedbacks.getCreDate().getTime();
		refresh = feedbacks.getRefresh().getTime();
		state = feedbacks.getState();
	}

	public int getFee_id() {
		return fee_id;
	}

	public void setFee_id(int fee_id) {
		this.fee_id = fee_id;
	}

	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public long getCre_date() {
		return cre_date;
	}

	public void setCre_date(long cre_date) {
		this.cre_date = cre_date;
	}

	public long getRefresh() {
		return refresh;
	}

	public void setRefresh(long refresh) {
		this.refresh = refresh;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
