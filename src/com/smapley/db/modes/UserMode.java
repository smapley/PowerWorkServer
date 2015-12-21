package com.smapley.db.modes;

import com.smapley.bean.User;
import com.smapley.bean.UserBase;
import com.smapley.db.entity.UserBaseEntity;
import com.smapley.db.entity.UserEntity;

public class UserMode {
	private UserEntity userEntity;

	private UserBaseEntity userBaseEntity;

	public UserMode() {

	}

	public UserMode(UserBase userBase, User user) {
		userBaseEntity = new UserBaseEntity(userBase);
		userEntity = new UserEntity(user);
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public UserBaseEntity getUserBaseEntity() {
		return userBaseEntity;
	}

	public void setUserBaseEntity(UserBaseEntity userBaseEntity) {
		this.userBaseEntity = userBaseEntity;
	}

}
