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
	private String nickname;
	private String truename;
	private String picUrl;
	private String phone;
	private Timestamp birthday;
	private Timestamp creDate;
	private String skey;
	private Set<Praise> praises = new HashSet<Praise>(0);
	private Set<Note> notes = new HashSet<Note>(0);
	private Set<Folder> folders = new HashSet<Folder>(0);
	private Set<Discuss> discusses = new HashSet<Discuss>(0);
	private Set<TasUse> tasUses = new HashSet<TasUse>(0);
	private Set<Dynamic> dynamics = new HashSet<Dynamic>(0);
	private Set<Feedbacks> feedbackses = new HashSet<Feedbacks>(0);
	private Set<File> files = new HashSet<File>(0);
	private Set<ProUse> proUses = new HashSet<ProUse>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public User(String username, String password, String nickname,
			String truename, String picUrl, String phone, Timestamp birthday,
			Timestamp creDate, String skey, Set<Praise> praises,
			Set<Note> notes, Set<Folder> folders, Set<Discuss> discusses,
			Set<TasUse> tasUses, Set<Dynamic> dynamics,
			Set<Feedbacks> feedbackses, Set<File> files, Set<ProUse> proUses) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.truename = truename;
		this.picUrl = picUrl;
		this.phone = phone;
		this.birthday = birthday;
		this.creDate = creDate;
		this.skey = skey;
		this.praises = praises;
		this.notes = notes;
		this.folders = folders;
		this.discusses = discusses;
		this.tasUses = tasUses;
		this.dynamics = dynamics;
		this.feedbackses = feedbackses;
		this.files = files;
		this.proUses = proUses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "use_id", unique = true, nullable = false)
	public Integer getUseId() {
		return this.useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Column(name = "skey")
	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Praise> getPraises() {
		return this.praises;
	}

	public void setPraises(Set<Praise> praises) {
		this.praises = praises;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Folder> getFolders() {
		return this.folders;
	}

	public void setFolders(Set<Folder> folders) {
		this.folders = folders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Discuss> getDiscusses() {
		return this.discusses;
	}

	public void setDiscusses(Set<Discuss> discusses) {
		this.discusses = discusses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<TasUse> getTasUses() {
		return this.tasUses;
	}

	public void setTasUses(Set<TasUse> tasUses) {
		this.tasUses = tasUses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Dynamic> getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(Set<Dynamic> dynamics) {
		this.dynamics = dynamics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Feedbacks> getFeedbackses() {
		return this.feedbackses;
	}

	public void setFeedbackses(Set<Feedbacks> feedbackses) {
		this.feedbackses = feedbackses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<File> getFiles() {
		return this.files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<ProUse> getProUses() {
		return this.proUses;
	}

	public void setProUses(Set<ProUse> proUses) {
		this.proUses = proUses;
	}

}