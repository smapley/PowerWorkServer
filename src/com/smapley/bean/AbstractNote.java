package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractNote entity provides the base persistence definition of the Note
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNote implements java.io.Serializable {

	// Fields

	private Integer notId;
	private User user;
	private Timestamp alarm;
	private String name;
	private Timestamp creDate;
	private Set noteDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractNote() {
	}

	/** full constructor */
	public AbstractNote(User user, Timestamp alarm, String name,
			Timestamp creDate, Set noteDetailses) {
		this.user = user;
		this.alarm = alarm;
		this.name = name;
		this.creDate = creDate;
		this.noteDetailses = noteDetailses;
	}

	// Property accessors

	public Integer getNotId() {
		return this.notId;
	}

	public void setNotId(Integer notId) {
		this.notId = notId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Timestamp alarm) {
		this.alarm = alarm;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	public Set getNoteDetailses() {
		return this.noteDetailses;
	}

	public void setNoteDetailses(Set noteDetailses) {
		this.noteDetailses = noteDetailses;
	}

}