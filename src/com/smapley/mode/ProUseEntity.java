package com.smapley.mode;

import com.smapley.bean.ProUse;

public class ProUseEntity {

	private int pro_id;
	private int use_id;
	private String user_truename;
	private String pic_url;
	private int rank;

	public ProUseEntity(ProUse prouse) {
		use_id = prouse.getId().getUser().getUseId();
		user_truename=prouse.getId().getUser().getTruename();
		pic_url=prouse.getId().getUser().getPicUrl();
		pro_id = prouse.getId().getProject().getProId();
		rank = prouse.getRank();
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getUser_truename() {
		return user_truename;
	}

	public void setUser_truename(String user_truename) {
		this.user_truename = user_truename;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
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

}
