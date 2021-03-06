package com.smapley.db.entity;

import com.smapley.bean.User;

public class UserEntity {
	private int useId;
	private String username;
	private String password;
	private String skey;
	private String nickname;
	private String truename;
	private String picUrl;
	private String phone;
	private long birthday;
	private long creDate;
	private long refresh;
	private int state;

	public UserEntity() {

	}

	public UserEntity(User user) {
		setUseId(user.getUseId());
		setUsername(user.getUsername());
		setPassword(user.getPassword());
		setSkey(user.getSkey());
		setNickname(user.getNickname());
		setTruename(user.getTruename());
		setPicUrl(user.getPicUrl());
		setPhone(user.getPhone());
		setBirthday(user.getBirthday().getTime());
		setCreDate(user.getCreDate().getTime());
		setRefresh(user.getRefresh().getTime());
		setState(user.getState());
	}

	public int getUseId() {
		return useId;
	}

	public void setUseId(int useId) {
		this.useId = useId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getBirthday() {
		return birthday;
	}

	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}

	public long getCreDate() {
		return creDate;
	}

	public void setCreDate(long creDate) {
		this.creDate = creDate;
	}

	public long getRefresh() {
		return refresh;
	}

	public void setRefresh(long refresh) {
		this.refresh = refresh;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
