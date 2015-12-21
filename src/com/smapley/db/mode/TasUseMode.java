package com.smapley.db.mode;

import com.smapley.bean.TasUse;
import com.smapley.db.entity.TasUseEntity;
import com.smapley.db.entity.UserEntity;

public class TasUseMode {

	private TasUseEntity tasUseEntity;

	private UserEntity userEntity;
	
	public TasUseMode() {

	}

	public TasUseMode(TasUse tasuse) {
		tasUseEntity=new TasUseEntity(tasuse);
		
		userEntity=new UserEntity(tasuse.getUser());
		
		
	}

	

	public TasUseEntity getTasUseEntity() {
		return tasUseEntity;
	}

	public void setTasUseEntity(TasUseEntity tasUseEntity) {
		this.tasUseEntity = tasUseEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	
}
