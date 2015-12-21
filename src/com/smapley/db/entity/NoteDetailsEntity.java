package com.smapley.db.entity;

import com.smapley.bean.NoteDetails;

public class NoteDetailsEntity {

	private int det_id;
	private int not_id;
	private int type;
	private String text;
	private String path;
	private long length;
	private long refresh;
	private int state;

	public NoteDetailsEntity(NoteDetails noteDetails) {
		det_id = noteDetails.getDetId();
		not_id = noteDetails.getNote().getNotId();
		type = noteDetails.getType();
		text = noteDetails.getText();
		path = noteDetails.getPath();
		if (noteDetails.getLength() != null)
			length = noteDetails.getLength().getTime();
		refresh=noteDetails.getRefresh().getTime();
		state=noteDetails.getState();
	}

	public int getDet_id() {
		return det_id;
	}

	public void setDet_id(int det_id) {
		this.det_id = det_id;
	}


	public int getNot_id() {
		return not_id;
	}

	public void setNot_id(int not_id) {
		this.not_id = not_id;
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
