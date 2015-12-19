package com.smapley.entity;

import com.smapley.bean.Discuss;

public class DiscussEntity {

	private int dis_id;
	private int use_id;
	private String details;
	private int dyn_id;
	private long refresh;
	private int state;
	
	public DiscussEntity(){
		
	}
	public DiscussEntity(Discuss discuss){
		dis_id=discuss.getDisId();
		use_id=discuss.getUser().getUseId();
		details=discuss.getDetails();
		dyn_id=discuss.getDynamic().getDynId();
		refresh=discuss.getRefresh().getTime();
		state=discuss.getState();
	}
	public int getDis_id() {
		return dis_id;
	}
	public void setDis_id(int dis_id) {
		this.dis_id = dis_id;
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
