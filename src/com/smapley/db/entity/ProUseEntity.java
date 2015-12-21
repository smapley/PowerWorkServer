package com.smapley.db.entity;

import com.smapley.bean.ProUse;

public class ProUseEntity {

	private int id;
	private int pro_id;
	private int use_id;
	private int rank;
	private long refresh;
	private int state;
	

	public ProUseEntity(ProUse prouse) {	
		id=prouse.getId();
		use_id = prouse.getUser().getUseId();
		pro_id = prouse.getProject().getProId();
		rank = prouse.getRank();
		refresh=prouse.getRefresh().getTime();
		state=prouse.getState();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}


	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
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
