package com.smapley.bean;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Note entity. @author MyEclipse Persistence Tools
 */
public class Note extends AbstractNote implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Note() {
	}

	/** full constructor */
	public Note(User user, Timestamp alarm, String name, Timestamp creDate,
			Set noteDetailses) {
		super(user, alarm, name, creDate, noteDetailses);
	}

}
