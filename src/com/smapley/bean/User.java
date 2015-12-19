package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "User", catalog = "PowerWork")
public class User implements java.io.Serializable {

	// Fields

	private Integer useId;
	private UserBase userBase;
	private String nickname;
	private String truename;
	private String picUrl;
	private String phone;
	private Timestamp birthday;
	private Timestamp creDate;
	private Timestamp refresh;
	private Integer state;
	private Set<ProUse> proUses = new HashSet<ProUse>(0);
	private Set<TasUse> tasUses = new HashSet<TasUse>(0);
	private Set<Note> notes = new HashSet<Note>(0);
	private Set<Folder> folders = new HashSet<Folder>(0);
	private Set<Praise> praises = new HashSet<Praise>(0);
	private Set<Feedbacks> feedbackses = new HashSet<Feedbacks>(0);
	private Set<File> files = new HashSet<File>(0);
	private Set<Discuss> discusses = new HashSet<Discuss>(0);
	private Set<Dynamic> dynamics = new HashSet<Dynamic>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer useId, UserBase userBase) {
		this.useId = useId;
		this.userBase = userBase;
	}

	/** full constructor */
	public User(Integer useId, UserBase userBase, String nickname,
			String truename, String picUrl, String phone, Timestamp birthday,
			Timestamp creDate, Timestamp refresh, Integer state,
			Set<ProUse> proUses, Set<TasUse> tasUses, Set<Note> notes,
			Set<Folder> folders, Set<Praise> praises,
			Set<Feedbacks> feedbackses, Set<File> files,
			Set<Discuss> discusses, Set<Dynamic> dynamics) {
		this.useId = useId;
		this.userBase = userBase;
		this.nickname = nickname;
		this.truename = truename;
		this.picUrl = picUrl;
		this.phone = phone;
		this.birthday = birthday;
		this.creDate = creDate;
		this.refresh = refresh;
		this.state = state;
		this.proUses = proUses;
		this.tasUses = tasUses;
		this.notes = notes;
		this.folders = folders;
		this.praises = praises;
		this.feedbackses = feedbackses;
		this.files = files;
		this.discusses = discusses;
		this.dynamics = dynamics;
	}

	// Property accessors
	@Id
	@Column(name = "use_id", unique = true, nullable = false)
	public Integer getUseId() {
		return this.useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "use_id", unique = true, nullable = false, insertable = false, updatable = false)
	public UserBase getUserBase() {
		return this.userBase;
	}

	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}

	@Column(name = "nickname", length = 20)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "truename", length = 20)
	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	@Column(name = "pic_url")
	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "birthday", length = 19)
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "cre_date", length = 19)
	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	@Column(name = "refresh", length = 19)
	public Timestamp getRefresh() {
		return this.refresh;
	}

	public void setRefresh(Timestamp refresh) {
		this.refresh = refresh;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<ProUse> getProUses() {
		return this.proUses;
	}

	public void setProUses(Set<ProUse> proUses) {
		this.proUses = proUses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<TasUse> getTasUses() {
		return this.tasUses;
	}

	public void setTasUses(Set<TasUse> tasUses) {
		this.tasUses = tasUses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Folder> getFolders() {
		return this.folders;
	}

	public void setFolders(Set<Folder> folders) {
		this.folders = folders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Praise> getPraises() {
		return this.praises;
	}

	public void setPraises(Set<Praise> praises) {
		this.praises = praises;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Feedbacks> getFeedbackses() {
		return this.feedbackses;
	}

	public void setFeedbackses(Set<Feedbacks> feedbackses) {
		this.feedbackses = feedbackses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<File> getFiles() {
		return this.files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Discuss> getDiscusses() {
		return this.discusses;
	}

	public void setDiscusses(Set<Discuss> discusses) {
		this.discusses = discusses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Dynamic> getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(Set<Dynamic> dynamics) {
		this.dynamics = dynamics;
	}

}