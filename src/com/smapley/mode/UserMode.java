package com.smapley.mode;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.Note;
import com.smapley.bean.ProUse;
import com.smapley.bean.User;
import com.smapley.entity.UserEntity;

public class UserMode {
	private UserEntity userEntity;

	private List<NoteMode> listNoteModes;
	private List<ProjectMode> listProjectModes;

	public UserMode() {

	}

	public UserMode(User user, long time) {
		if (user.getRefresh().getTime() > time)
			userEntity = new UserEntity(user);

		listNoteModes = new ArrayList<NoteMode>();
		for (Note note : user.getNotes()) {
			listNoteModes.add(new NoteMode(note,time));
		}

		listProjectModes = new ArrayList<ProjectMode>();
		for (ProUse prouse : user.getProUses()) {
			listProjectModes.add(new ProjectMode(prouse.getProject(),time));
		}
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<NoteMode> getListNoteModes() {
		return listNoteModes;
	}

	public void setListNoteModes(List<NoteMode> listNoteModes) {
		this.listNoteModes = listNoteModes;
	}

	public List<ProjectMode> getListProjectModes() {
		return listProjectModes;
	}

	public void setListProjectModes(List<ProjectMode> listProjectModes) {
		this.listProjectModes = listProjectModes;
	}

}
