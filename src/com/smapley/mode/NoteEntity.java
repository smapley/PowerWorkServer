package com.smapley.mode;

import com.smapley.bean.Note;

public class NoteEntity {

	private int not_id;
	private int use_id;
	private long alarm;
	private String name;
	private long cre_date;

	public NoteEntity() {

	}

	public NoteEntity(Note note) {
		not_id = note.getNotId();
		use_id = note.getUser().getUseId();
		if (note.getAlarm() != null)
			alarm = note.getAlarm().getTime();
		name = note.getName();
		if (note.getCreDate() != null)
			cre_date = note.getCreDate().getTime();
	}

	public int getNot_id() {
		return not_id;
	}

	public void setNot_id(int not_id) {
		this.not_id = not_id;
	}

	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}

	public long getAlarm() {
		return alarm;
	}

	public void setAlarm(long alarm) {
		this.alarm = alarm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCre_date() {
		return cre_date;
	}

	public void setCre_date(long cre_date) {
		this.cre_date = cre_date;
	}
}