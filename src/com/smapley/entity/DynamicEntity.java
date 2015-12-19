package com.smapley.entity;

import com.smapley.bean.Dynamic;

public class DynamicEntity {

	private int dyn_id;
	private int use_id;
	private int tas_id;
	private int type;
	private int pro_id;
	private String pic_url;
	private int fil_id;
	private long refresh;
	private int state;
	private long cre_date;

	public DynamicEntity() {

	}

	public DynamicEntity(Dynamic dynamic) {
		dyn_id = dynamic.getDynId();
		use_id = dynamic.getUser().getUseId();
		if (dynamic.getTask() != null)
			tas_id = dynamic.getTask().getTasId();
		type = dynamic.getType();
		pro_id = dynamic.getProject().getProId();
		pic_url = dynamic.getUser().getPicUrl();
		if (dynamic.getFile() != null)
			fil_id = dynamic.getFile().getFilId();
		cre_date = dynamic.getCreDate().getTime();
		refresh = dynamic.getRefresh().getTime();
		state = dynamic.getState();

	}

	public int getDyn_id() {
		return dyn_id;
	}

	public void setDyn_id(int dyn_id) {
		this.dyn_id = dyn_id;
	}

	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}

	public int getTas_id() {
		return tas_id;
	}

	public void setTas_id(int tas_id) {
		this.tas_id = tas_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public int getFil_id() {
		return fil_id;
	}

	public void setFil_id(int fil_id) {
		this.fil_id = fil_id;
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

	public long getCre_date() {
		return cre_date;
	}

	public void setCre_date(long cre_date) {
		this.cre_date = cre_date;
	}

}
