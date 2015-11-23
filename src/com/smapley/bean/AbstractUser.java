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
	private Set projects = new HashSet(0);
	private Set tasks = new HashSet(0);
	private Set files = new HashSet(0);
	private Set feedbackses = new HashSet(0);
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
			Timestamp creDate, String skey, Set projects, Set tasks, Set files,
			Set feedbackses, Set proUses) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.truename = truename;
		this.picUrl = picUrl;
		this.phone = phone;
		this.birthday = birthday;
		this.creDate = creDate;
		this.skey = skey;
		this.projects = projects;
		this.tasks = tasks;
		this.files = files;
		this.feedbackses = feedbackses;
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

	public Set getProjects() {
		return this.projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	public Set getTasks() {
		return this.tasks;
	}

	public void setTasks(Set tasks) {
		this.tasks = tasks;
	}

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

	public Set getFeedbackses() {
		return this.feedbackses;
	}

	public void setFeedbackses(Set feedbackses) {
		this.feedbackses = feedbackses;
	}

	public Set getProUses() {
		return this.proUses;
	}

	public void setProUses(Set proUses) {
		this.proUses = proUses;
	}

}