package com.smapley.mode;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.Dynamic;
import com.smapley.bean.Folder;
import com.smapley.bean.ProUse;
import com.smapley.bean.Project;
import com.smapley.bean.Task;
import com.smapley.entity.ProjectEntity;

public class ProjectMode {

	private ProjectEntity projectEntity;

	private List<ProUseMode> listProUseModes;
	private List<TaskMode> listTaskModes;
	private List<DynamicMode> listDynamicModes;
	private List<FolderMode> listFolderModes;

	public ProjectMode(Project project, long time) {
		if (project.getRefresh().getTime() > time)
			projectEntity = new ProjectEntity(project);

		listProUseModes = new ArrayList<ProUseMode>();
		for (ProUse prouse : project.getProUses()) {
			listProUseModes.add(new ProUseMode(prouse,time));
		}

		listTaskModes = new ArrayList<TaskMode>();
		for (Task task : project.getTasks()) {
			listTaskModes.add(new TaskMode(task,time));
		}

		listDynamicModes = new ArrayList<DynamicMode>();
		for (Dynamic dynamic : project.getDynamics()) {
			listDynamicModes.add(new DynamicMode(dynamic,time));
		}

		listFolderModes = new ArrayList<FolderMode>();
		for (Folder folder : project.getFolders()) {
			listFolderModes.add(new FolderMode(folder,time));
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

	public List<TaskMode> getListTaskModes() {
		return listTaskModes;
	}

	public void setListTaskModes(List<TaskMode> listTaskModes) {
		this.listTaskModes = listTaskModes;
	}

	public List<DynamicMode> getListDynamicModes() {
		return listDynamicModes;
	}

	public void setListDynamicModes(List<DynamicMode> listDynamicModes) {
		this.listDynamicModes = listDynamicModes;
	}

	public List<FolderMode> getListFolderModes() {
		return listFolderModes;
	}

	public void setListFolderModes(List<FolderMode> listFolderModes) {
		this.listFolderModes = listFolderModes;
	}

}
