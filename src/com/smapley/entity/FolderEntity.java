package com.smapley.entity;

import com.smapley.bean.Folder;

public class FolderEntity {

	private int fol_id;
	private String name;
	private int pro_id;
	private int fol_id2;
	private int use_id;
	private long refresh;
	private int state;

	public FolderEntity() {

	}

	public FolderEntity(Folder folder) {
		fol_id = folder.getFolId();
		name = folder.getName();
		if (folder.getProject() != null)
			pro_id = folder.getProject().getProId();
		if (folder.getFolder() != null)
			fol_id2 = folder.getFolder().getFolId();
		use_id = folder.getUser().getUseId();
		refresh=folder.getRefresh().getTime();
		state=folder.getState();
	}

	public int getFol_id() {
		return fol_id;
	}

	public void setFol_id(int fol_id) {
		this.fol_id = fol_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public int getFol_id2() {
		return fol_id2;
	}

	public void setFol_id2(int fol_id2) {
		this.fol_id2 = fol_id2;
	}

	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
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
