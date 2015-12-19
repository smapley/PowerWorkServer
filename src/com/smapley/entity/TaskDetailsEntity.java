package com.smapley.entity;

import com.smapley.bean.TaskDetails;


public class TaskDetailsEntity {

	private int det_id;
	private int tas_id;
	private int type;
	private String text;
	private String path;
	private long length;
	private long refresh;
	private int state;

	public TaskDetailsEntity(TaskDetails taskDetails) {
		det_id = taskDetails.getDetId();
		tas_id = taskDetails.getTask().getTasId();
		type = taskDetails.getType();
		text = taskDetails.getText();
		path = taskDetails.getPath();
		if (taskDetails.getLength() != null)
			length = taskDetails.getLength().getTime();
		refresh=taskDetails.getRefresh().getTime();
		state=taskDetails.getState();

	}

	public int getDet_id() {
		return det_id;
	}

	public void setDet_id(int det_id) {
		this.det_id = det_id;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
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
