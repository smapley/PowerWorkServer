package com.smapley.db.entity;

import com.smapley.bean.Task;

public class TaskEntity {
	private int tas_id;
	private int pro_id;
	private String name;
	private long sta_date;
	private long end_date;
	private int progress;
	private int priority;
	private long cre_date;
	private long refresh;
	private int state;
	

	public TaskEntity() {

	}

	public TaskEntity(Task task) {		
		tas_id = task.getTasId();
		pro_id = task.getProject().getProId();
		name = task.getName();
		if (task.getStaDate() != null)
			sta_date = task.getStaDate().getTime();
		if (task.getEndDate() != null)
			end_date = task.getEndDate().getTime();
		if (task.getProgress() != null)
			progress = task.getProgress();
		if (task.getPriority() != null)
			priority = task.getPriority();
		if (task.getCreDate() != null)
			cre_date = task.getCreDate().getTime();		
		refresh=task.getRefresh().getTime();
		state=task.getState();

	}

	public int getTas_id() {
		return tas_id;
	}

	public void setTas_id(int tas_id) {
		this.tas_id = tas_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSta_date() {
		return sta_date;
	}

	public void setSta_date(long sta_date) {
		this.sta_date = sta_date;
	}

	public long getEnd_date() {
		return end_date;
	}

	public void setEnd_date(long end_date) {
		this.end_date = end_date;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public long getCre_date() {
		return cre_date;
	}

	public void setCre_date(long cre_date) {
		this.cre_date = cre_date;
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
