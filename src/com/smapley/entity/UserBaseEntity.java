package com.smapley.entity;

import com.smapley.bean.UserBase;
import com.smapley.utils.Code;

public class UserBaseEntity {
	private int useId;
	private String username;
	private String password;
	private String skey;
	private long refresh;
	private int state;
	public UserBaseEntity() {

	}

	public UserBaseEntity(UserBase userBase) {
		setUseId(userBase.getUseId());
		setUsername(userBase.getUsername());
		setPassword(Code.enCode(userBase.getPassword()));
		setSkey(Code.enCode(userBase.getSkey()));
		setRefresh(userBase.getRefresh().getTime());
		setState(userBase.getState());
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
