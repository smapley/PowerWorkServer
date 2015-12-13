package com.smapley.mode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.smapley.bean.TasUse;
import com.smapley.bean.Task;

public class OtherTaskEntity {
	private int tas_id;
	private int pro_id;
	private String name;
	private long sta_date;
	private long end_date;
	private int progress;
	private int priority;
	private long cre_date;

	private List<TasUseEntity> listTasUse;

	public OtherTaskEntity() {

	}

	@SuppressWarnings("unchecked")
	public OtherTaskEntity(Task task) {		
		tas_id = task.getTasId();
		pro_id = task.getProject().getProId();
		name = task.getName();
		if (task.getStaDate() != null)
			sta_date = task.getStaDate().getTime();
		if (task.getEndDate() != null)
			end_date = task.getEndDate().getTime();
		if (task.getProgress() != null)
			progress = task.getProgress();
		if (task.getPriority() != null)
			priority = task.getPriority();
		if (task.getCreDate() != null)
			cre_date = task.getCreDate().getTime();		
		listTasUse=new ArrayList<TasUseEntity>();
		for(TasUse tasuse:(Set<TasUse>)task.getTasUses()){
			listTasUse.add(new TasUseEntity(tasuse));
		}

	}

	public int getTas_id() {
		return tas_id;
	}

	public void setTas_id(int tas_id) {
		this.tas_id = tas_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSta_date() {
		return sta_date;
	}

	public void setSta_date(long sta_date) {
		this.sta_date = sta_date;
	}

	public long getEnd_date() {
		return end_date;
	}

	public void setEnd_date(long end_date) {
		this.end_date = end_date;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public long getCre_date() {
		return cre_date;
	}

	public void setCre_date(long cre_date) {
		this.cre_date = cre_date;
	}

	public List<TasUseEntity> getListTasUse() {
		return listTasUse;
	}

	public void setListTasUse(List<TasUseEntity> listTasUse) {
		this.listTasUse = listTasUse;
	}

	

}
