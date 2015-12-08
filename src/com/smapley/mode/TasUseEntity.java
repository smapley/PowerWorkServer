package com.smapley.mode;

import com.smapley.bean.TasUse;

public class TasUseEntity {

	private int use_id;
	private int tas_id;
	private int rank;

	public TasUseEntity(){
		
	}
	public TasUseEntity(TasUse tasuse) {
		use_id = tasuse.getId().getUser().getUseId();
		tas_id = tasuse.getId().getTask().getTasId();
		rank = tasuse.getId().getRank();
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
}
