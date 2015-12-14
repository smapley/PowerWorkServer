package com.smapley.bean;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * NoteDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Note_Details", catalog = "PowerWork")
public class NoteDetails implements java.io.Serializable {

	// Fields

	private Integer detId;
	private Note note;
	private Integer type;
	private String text;
	private String path;
	private Time length;

	// Constructors

	/** default constructor */
	public NoteDetails() {
	}

	/** full constructor */
	public NoteDetails(Note note, Integer type, String text, String path,
			Time length) {
		this.note = note;
		this.type = type;
		this.text = text;
		this.path = path;
		this.length = length;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "det_id", unique = true, nullable = false)
	public Integer getDetId() {
		return this.detId;
	}

	public void setDetId(Integer detId) {
		this.detId = detId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "not_id")
	public Note getNote() {
		return this.note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "path")
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "length", length = 8)
	public Time getLength() {
		return this.length;
	}

	public void setLength(Time length) {
		this.length = length;
	}

}