package com.smapley.db.modes;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.ProUse;
import com.smapley.bean.Project;
import com.smapley.db.entity.ProjectEntity;
import com.smapley.db.service.XDAO;

public class ProjectMode {

	private ProjectEntity projectEntity;

	private List<ProUseMode> listProUseModes;
	@SuppressWarnings("unchecked")
	public ProjectMode(Project project, long time) {
		if (project.getRefresh().getTime() > time)
			projectEntity = new ProjectEntity(project);

		listProUseModes = new ArrayList<ProUseMode>();
		for (ProUse prouse : (List<ProUse>) XDAO.proUseDAO.findByProperty(
				"project", project)) {
			if (prouse.getRefresh().getTime() > time)
				listProUseModes.add(new ProUseMode(prouse,time));
		}

	}

	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public List<ProUseMode> getListProUseModes() {
		return listProUseModes;
	}

	public void setListProUseModes(List<ProUseMode> listProUseModes) {
		this.listProUseModes = listProUseModes;
	}

	
	

}
