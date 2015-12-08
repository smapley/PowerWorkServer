package com.smapley.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

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
	private Set praises = new HashSet(0);
	private Set notes = new HashSet(0);
	private Set folders = new HashSet(0);
	private Set discusses = new HashSet(0);
	private Set tasUses = new HashSet(0);
	private Set dynamics = new HashSet(0);
	private Set feedbackses = new HashSet(0);
	private Set files = new HashSet(0);
	private Set proUses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public AbstractUser(String username, String password, String nickname,
			String truename, String picUrl, String phone, Timestamp birthday,
			Timestamp creDate, String skey, Set praises, Set notes,
			Set folders, Set discusses, Set tasUses, Set dynamics,
			Set feedbackses, Set files, Set proUses) {
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

	public Integer getUseId() {
		return this.useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Timestamp getCreDate() {
		return this.creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public Set getPraises() {
		return this.praises;
	}

	public void setPraises(Set praises) {
		this.praises = praises;
	}

	public Set getNotes() {
		return this.notes;
	}

	public void setNotes(Set notes) {
		this.notes = notes;
	}

	public Set getFolders() {
		return this.folders;
	}

	public void setFolders(Set folders) {
		this.folders = folders;
	}

	public Set getDiscusses() {
		return this.discusses;
	}

	public void setDiscusses(Set discusses) {
		this.discusses = discusses;
	}

	public Set getTasUses() {
		return this.tasUses;
	}

	public void setTasUses(Set tasUses) {
		this.tasUses = tasUses;
	}

	public Set getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(Set dynamics) {
		this.dynamics = dynamics;
	}

	public Set getFeedbackses() {
		return this.feedbackses;
	}

	public void setFeedbackses(Set feedbackses) {
		this.feedbackses = feedbackses;
	}

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

	public Set getProUses() {
		return this.proUses;
	}

	public void setProUses(Set proUses) {
		this.proUses = proUses;
	}

}