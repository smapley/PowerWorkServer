package com.smapley.mode;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.TasUse;
import com.smapley.bean.Task;
import com.smapley.bean.TaskDetails;
import com.smapley.entity.TaskDetailsEntity;
import com.smapley.entity.TaskEntity;

public class TaskMode {
	private TaskEntity taskEntity;

	private List<TaskDetailsEntity> listTaskDetailsEntities;
	private List<TasUseMode> listTasUseModes;

	public TaskMode() {

	}

	public TaskMode(Task task, long time) {
		if (task.getRefresh().getTime() > time)
			taskEntity = new TaskEntity(task);

		listTaskDetailsEntities = new ArrayList<TaskDetailsEntity>();
		for (TaskDetails taskDetails : task.getTaskDetailses()) {
			if (taskDetails.getRefresh().getTime() > time)
				listTaskDetailsEntities.add(new TaskDetailsEntity(taskDetails));
		}

		listTasUseModes = new ArrayList<TasUseMode>();
		for (TasUse tasuse : task.getTasUses()) {
			if (tasuse.getRefresh().getTime() > time)
				listTasUseModes.add(new TasUseMode(tasuse));
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

	public List<TasUseMode> getListTasUseModes() {
		return listTasUseModes;
	}

	public void setListTasUseModes(List<TasUseMode> listTasUseModes) {
		this.listTasUseModes = listTasUseModes;
	}

}
