package com.smapley.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
	private String username;
	private String password;
	private String skey;
	private String nickname;
	private String truename;
	private String picUrl;
	private String phone;
	private Timestamp birthday;
	private Timestamp creDate;
	private Timestamp refresh;
	private Integer state;
	private Set<Message> messagesForUseId = new HashSet<Message>(0);
	private Set<Message> messagesForSrcUseId = new HashSet<Message>(0);
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


	/** full constructor */
	public User(String username, String password, String skey, String nickname,
			String truename, String picUrl, String phone, Timestamp birthday,
			Timestamp creDate, Timestamp refresh, Integer state,
			Set<Message> messagesForUseId, Set<Message> messagesForSrcUseId,
			Set<ProUse> proUses, Set<TasUse> tasUses, Set<Note> notes,
			Set<Folder> folders, Set<Praise> praises,
			Set<Feedbacks> feedbackses, Set<File> files,
			Set<Discuss> discusses, Set<Dynamic> dynamics) {
		this.username = username;
		this.password = password;
		this.skey = skey;
		this.nickname = nickname;
		this.truename = truename;
		this.picUrl = picUrl;
		this.phone = phone;
		this.birthday = birthday;
		this.creDate = creDate;
		this.refresh = refresh;
		this.state = state;
		this.messagesForUseId = messagesForUseId;
		this.messagesForSrcUseId = messagesForSrcUseId;
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
	@Id @GeneratedValue(strategy = IDENTITY)
	@Column(name = "use_id", unique = true, nullable = false)
	public Integer getUseId() {
		return this.useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}
	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "skey")
	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUseId")
	public Set<Message> getMessagesForUseId() {
		return this.messagesForUseId;
	}

	public void setMessagesForUseId(Set<Message> messagesForUseId) {
		this.messagesForUseId = messagesForUseId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userBySrcUseId")
	public Set<Message> getMessagesForSrcUseId() {
		return this.messagesForSrcUseId;
	}

	public void setMessagesForSrcUseId(Set<Message> messagesForSrcUseId) {
		this.messagesForSrcUseId = messagesForSrcUseId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ProUse> getProUses() {
		return this.proUses;
	}

	public void setProUses(Set<ProUse> proUses) {
		this.proUses = proUses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<TasUse> getTasUses() {
		return this.tasUses;
	}

	public void setTasUses(Set<TasUse> tasUses) {
		this.tasUses = tasUses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
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