package com.smapley.mode;

import java.util.Set;

import com.smapley.bean.Discuss;
import com.smapley.bean.Dynamic;
import com.smapley.bean.Praise;
import com.smapley.bean.User;

public class DynamicEntity {

	private int dyn_id;
	private int use_id;
	private int tas_id;
	private int type;
	private int pro_id;
	private String pic_url;
	private String use_name;
	private long cre_date;
	private String dPic_url;
	private String detai;
	private boolean isPraise;
	private int praise_num;
	private boolean isDiscuss;
	private int discuss_num;

	public DynamicEntity() {

	}

	public DynamicEntity(Dynamic dynamic, User user) {
		dyn_id = dynamic.getDynId();
		use_id = dynamic.getUser().getUseId();
		if (dynamic.getTask() != null)
			tas_id = dynamic.getTask().getTasId();
		type = dynamic.getType();
		pro_id = dynamic.getProject().getProId();
		pic_url = dynamic.getUser().getPicUrl();
		use_name = dynamic.getUser().getTruename();
		cre_date = dynamic.getCreDate().getTime();
		dPic_url = dynamic.getPicUrl();
		switch (type) {
		case 0:
			detai = dynamic.getProject().getName();
			dPic_url=dynamic.getProject().getPicUrl();
			break;
		case 1:
			detai=dynamic.getTask().getName();
			break;
		case 2:
			detai=dynamic.getFile().getName();
			dPic_url=dynamic.getFile().getUrl();
			break;

		default:
			break;
		}
		@SuppressWarnings("unchecked")
		Set<Praise> praises = dynamic.getPraises();
		isPraise = true;
		for (Praise praise : praises) {
			if (praise.getUser().getUseId() == user.getUseId()) {
				isPraise = true;
				break;
			}
		}
		praise_num = praises.size();
		isDiscuss = false;
		@SuppressWarnings("unchecked")
		Set<Discuss> discusses = dynamic.getDiscusses();
		for (Discuss discuss : discusses) {
			if (discuss.getUser().getUseId() == user.getUseId()) {
				isDiscuss = true;
			}
		}
		discuss_num = discusses.size();

	}

	public int getDyn_id() {
		return dyn_id;
	}

	public void setDyn_id(int dyn_id) {
		this.dyn_id = dyn_id;
	}

	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}

	public int getTas_id() {
		return tas_id;
	}

	public void setTas_id(int tas_id) {
		this.tas_id = tas_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getUse_name() {
		return use_name;
	}

	public void setUse_name(String use_name) {
		this.use_name = use_name;
	}

	public long getCre_date() {
		return cre_date;
	}

	public void setCre_date(long cre_date) {
		this.cre_date = cre_date;
	}

	public String getdPic_url() {
		return dPic_url;
	}

	public void setdPic_url(String dPic_url) {
		this.dPic_url = dPic_url;
	}

	public String getDetai() {
		return detai;
	}

	public void setDetai(String detai) {
		this.detai = detai;
	}

	public boolean isPraise() {
		return isPraise;
	}

	public void setPraise(boolean isPraise) {
		this.isPraise = isPraise;
	}

	public int getPraise_num() {
		return praise_num;
	}

	public void setPraise_num(int praise_num) {
		this.praise_num = praise_num;
	}

	public boolean isDiscuss() {
		return isDiscuss;
	}

	public void setDiscuss(boolean isDiscuss) {
		this.isDiscuss = isDiscuss;
	}

	public int getDiscuss_num() {
		return discuss_num;
	}

	public void setDiscuss_num(int discuss_num) {
		this.discuss_num = discuss_num;
	}

}
