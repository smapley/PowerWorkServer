package com.smapley.db.entity;

import com.smapley.bean.Praise;

public class PraiseEntity {
	private int pra_id;
	private int use_id;
	private int dyn_id;
	private long refresh;
	private int state;
	
	public PraiseEntity(Praise praise){
		pra_id=praise.getPraId();
		use_id=praise.getUser().getUseId();
		dyn_id=praise.getDynamic().getDynId();
		refresh=praise.getRefresh().getTime();
		state=praise.getState();
	}
	
	public int getPra_id() {
		return pra_id;
	}
	public void setPra_id(int pra_id) {
		this.pra_id = pra_id;
	}
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public int getDyn_id() {
		return dyn_id;
	}
	public void setDyn_id(int dyn_id) {
		this.dyn_id = dyn_id;
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
