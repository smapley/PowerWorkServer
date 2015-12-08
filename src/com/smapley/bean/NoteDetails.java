package com.smapley.bean;

import java.sql.Time;

/**
 * NoteDetails entity. @author MyEclipse Persistence Tools
 */
public class NoteDetails extends AbstractNoteDetails implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public NoteDetails() {
	}

	/** full constructor */
	public NoteDetails(Note note, Integer type, String text, String path,
			Time length) {
		super(note, type, text, path, length);
	}

}
