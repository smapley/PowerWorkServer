package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Note entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Note", catalog = "PowerWork")
public class Note implements java.io.Serializable {

	// Fields

	private Integer notId;
	private User user;
	private Timestamp alarm;
	private String name;
	private Timestamp creDate;
	private Set<NoteDetails> noteDetailses = new HashSet<NoteDetails>(0);

	// Constructors

	/** default constructor */
	public Note() {
	}

	/** full constructor */
	public Note(User user, Timestamp alarm, String name, Timestamp creDate,
			Set<NoteDetails> noteDetailses) {
		this.user = user;
		this.alarm = alarm;
		this.name = name;
		this.creDate = creDate;
		this.noteDetailses = noteDetailses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "not_id", unique = true, nullable = false)
	public Integer getNotId() {
		return this.notId;
	}

	public void setNotId(Integer notId) {
		this.notId = notId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "use_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "alarm", length = 19)
	public Timestamp getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Timestamp alarm) {
		this.alarm = alarm;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cre_date", length = 19)
	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "note")
	public Set<NoteDetails> getNoteDetailses() {
		return this.noteDetailses;
	}

	public void setNoteDetailses(Set<NoteDetails> noteDetailses) {
		this.noteDetailses = noteDetailses;
	}

}