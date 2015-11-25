package com.smapley.mode;

import com.smapley.bean.Project;

public class ProjectEntity{


	private int pro_id;
	private int use_id;
	private String name;
	private String pic_url;
	private long cre_date;

	public ProjectEntity(Project project){
		setPro_id(project.getProId());
		setUse_id(project.getUser().getUseId());
		setName(project.getName());
		setPic_url(project.getPicUrl());
		setCre_date(project.getCreDate().getTime());
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public long getCre_date() {
		return cre_date;
	}

	public void setCre_date(long cre_date) {
		this.cre_date = cre_date;
	}

}
