package com.smapley.mode;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.Discuss;
import com.smapley.bean.Dynamic;
import com.smapley.bean.Praise;
import com.smapley.entity.DiscussEntity;
import com.smapley.entity.DynamicEntity;
import com.smapley.entity.PraiseEntity;

public class DynamicMode {

	private DynamicEntity dynamicEntity;
	private List<DiscussEntity> listDiscussEntities;
	private List<PraiseEntity> listPraiseEntities;

	public DynamicMode() {

	}

	public DynamicMode(Dynamic dynamic, long time) {
		if (dynamic.getRefresh().getTime() > time)
			dynamicEntity = new DynamicEntity(dynamic);

		listDiscussEntities = new ArrayList<DiscussEntity>();
		for (Discuss discuss : dynamic.getDiscusses()) {
			if (discuss.getRefresh().getTime() > time)
				listDiscussEntities.add(new DiscussEntity(discuss));
		}

		listPraiseEntities = new ArrayList<PraiseEntity>();
		for (Praise praise : dynamic.getPraises()) {
			if (praise.getRefresh().getTime() > time)
				listPraiseEntities.add(new PraiseEntity(praise));
		}

	}

	public DynamicEntity getDynamicEntity() {
		return dynamicEntity;
	}

	public void setDynamicEntity(DynamicEntity dynamicEntity) {
		this.dynamicEntity = dynamicEntity;
	}

	public List<DiscussEntity> getListDiscussEntities() {
		return listDiscussEntities;
	}

	public void setListDiscussEntities(List<DiscussEntity> listDiscussEntities) {
		this.listDiscussEntities = listDiscussEntities;
	}

	public List<PraiseEntity> getListPraiseEntities() {
		return listPraiseEntities;
	}

	public void setListPraiseEntities(List<PraiseEntity> listPraiseEntities) {
		this.listPraiseEntities = listPraiseEntities;
	}

}
