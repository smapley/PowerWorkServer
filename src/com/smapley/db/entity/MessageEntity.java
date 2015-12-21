package com.smapley.db.entity;

import com.smapley.bean.Message;

public class MessageEntity {

	private int mes_id;
	private int use_id;
	private int src_use_id;
	private int type;
	private String details;
	private int pro_id;
	private int tas_id;
	private long cre_date;
	private long refresh;
	private int state;

	public MessageEntity(Message message) {
		mes_id = message.getMesId();
		use_id = message.getUserByUseId().getUseId();
		src_use_id = message.getUserBySrcUseId().getUseId();
		type = message.getType();
		details = message.getDetails();
		pro_id = message.getProject().getProId();
		tas_id = message.getTask().getTasId();
		cre_date = message.getCreDate().getTime();
		refresh = message.getRefresh().getTime();
		state = message.getState();

	}

	public int getMes_id() {
		return mes_id;
	}

	public void setMes_id(int mes_id) {
		this.mes_id = mes_id;
	}

	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}

	public int getSrc_use_id() {
		return src_use_id;
	}

	public void setSrc_use_id(int src_use_id) {
		this.src_use_id = src_use_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public int getTas_id() {
		return tas_id;
	}

	public void setTas_id(int tas_id) {
		this.tas_id = tas_id;
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
