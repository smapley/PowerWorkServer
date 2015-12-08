package com.smapley.bean;

import java.sql.Time;

/**
 * AbstractNoteDetails entity provides the base persistence definition of the
 * NoteDetails entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNoteDetails implements java.io.Serializable {

	// Fields

	private Integer detId;
	private Note note;
	private Integer type;
	private String text;
	private String path;
	private Time length;

	// Constructors

	/** default constructor */
	public AbstractNoteDetails() {
	}

	/** full constructor */
	public AbstractNoteDetails(Note note, Integer type, String text,
			String path, Time length) {
		this.note = note;
		this.type = type;
		this.text = text;
		this.path = path;
		this.length = length;
	}

	// Property accessors

	public Integer getDetId() {
		return this.detId;
	}

	public void setDetId(Integer detId) {
		this.detId = detId;
	}

	public Note getNote() {
		return this.note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Time getLength() {
		return this.length;
	}

	public void setLength(Time length) {
		this.length = length;
	}

}