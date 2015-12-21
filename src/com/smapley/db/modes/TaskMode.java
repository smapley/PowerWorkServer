package com.smapley.db.modes;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.TasUse;
import com.smapley.bean.Task;
import com.smapley.bean.TaskDetails;
import com.smapley.db.entity.TasUseEntity;
import com.smapley.db.entity.TaskDetailsEntity;
import com.smapley.db.entity.TaskEntity;
import com.smapley.db.service.XDAO;

public class TaskMode {
	private TaskEntity taskEntity;

	private List<TaskDetailsEntity> listTaskDetailsEntities;
	private List<TasUseEntity> tasUseEntities;

	public TaskMode() {

	}

	@SuppressWarnings("unchecked")
	public TaskMode(Task task, long time) {
		if (task.getRefresh().getTime() > time)
			taskEntity = new TaskEntity(task);

		listTaskDetailsEntities = new ArrayList<TaskDetailsEntity>();
		for (TaskDetails taskDetails : (List<TaskDetails>) XDAO.taskDetailsDAO
				.findByProperty("task", task)) {
			if (taskDetails.getRefresh().getTime() > time)
				listTaskDetailsEntities.add(new TaskDetailsEntity(taskDetails));
		}

		tasUseEntities = new ArrayList<TasUseEntity>();
		for (TasUse tasuse : (List<TasUse>) XDAO.tasUseDAO.findByProperty(
				"task", task)) {
			if (tasuse.getRefresh().getTime() > time)
				tasUseEntities.add(new TasUseEntity(tasuse));
		}
	}

	public TaskEntity getTaskEntity() {
		return taskEntity;
	}

	public void setTaskEntity(TaskEntity taskEntity) {
		this.taskEntity = taskEntity;
	}

	public List<TaskDetailsEntity> getListTaskDetailsEntities() {
		return listTaskDetailsEntities;
	}

	public void setListTaskDetailsEntities(
			List<TaskDetailsEntity> listTaskDetailsEntities) {
		this.listTaskDetailsEntities = listTaskDetailsEntities;
	}

	public List<TasUseEntity> getTasUseEntities() {
		return tasUseEntities;
	}

	public void setTasUseEntities(List<TasUseEntity> tasUseEntities) {
		this.tasUseEntities = tasUseEntities;
	}

	
}
