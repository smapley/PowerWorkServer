package com.smapley.mode;

import com.smapley.bean.Task;

public class PTaskEntity {
	private String name;
	private long time;
	private int task_id;
	private String pic_url;

	public PTaskEntity(Task task) {
		name = task.getName();
		time = task.getCreDate().getTime();
		task_id = task.getTasId();
		pic_url = "asdf";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}


	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
}
