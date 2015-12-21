package com.smapley.db.modes;

import com.smapley.bean.ProUse;
import com.smapley.db.entity.ProUseEntity;
import com.smapley.db.entity.UserEntity;

public class ProUseMode {

	private ProUseEntity proUseEntity;

	private UserEntity userEntity;

	public ProUseMode(ProUse prouse, long time) {
		if (prouse.getRefresh().getTime() > time)
			proUseEntity = new ProUseEntity(prouse);
		if (prouse.getUser().getRefresh().getTime() > time)
			userEntity = new UserEntity(prouse.getUser());
	}

	public ProUseEntity getProUseEntity() {
		return proUseEntity;
	}

	public void setProUseEntity(ProUseEntity proUseEntity) {
		this.proUseEntity = proUseEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}
