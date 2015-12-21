package com.smapley.db.entity;

import com.smapley.bean.TasUse;

public class TasUseEntity {

	private int id;
	private int use_id;
	private int tas_id;
	private int rank;
	private long refresh;
	private int state;

	public TasUseEntity() {

	}

	public TasUseEntity(TasUse tasuse) {
		id=tasuse.getId();
		use_id = tasuse.getUser().getUseId();
		tas_id = tasuse.getTask().getTasId();
		rank = tasuse.getRank();
		refresh = tasuse.getRefresh().getTime();
		state = tasuse.getState();
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
