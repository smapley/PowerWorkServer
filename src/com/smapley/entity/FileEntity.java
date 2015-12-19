package com.smapley.entity;

import com.smapley.bean.File;

public class FileEntity {
	private int fil_id;
    private int fol_id;
    private String name;
    private int type;
    private String url;
    private int use_id;
    private long cre_date;
    private long refresh;
	private int state;

    public FileEntity(){
    	
    }
    
    public FileEntity(File file){
    	fil_id=file.getFilId();
    	fol_id=file.getFolder().getFolId();
    	name=file.getName();
    	type=file.getType();
    	url=file.getUrl();
    	use_id=file.getUser().getUseId();
    	cre_date=file.getCreDate().getTime();
    	refresh=file.getRefresh().getTime();
    	state=file.getState();
    }
    
    public int getFil_id() {
        return fil_id;
    }

    public void setFil_id(int fil_id) {
        this.fil_id = fil_id;
    }

    public int getFol_id() {
        return fol_id;
    }

    public void setFol_id(int fol_id) {
        this.fol_id = fol_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUse_id() {
        return use_id;
    }

    public void setUse_id(int use_id) {
        this.use_id = use_id;
    }

    public long getCre_date() {
        return cre_date;
    }

    public void setCre_date(long cre_date) {
        this.cre_date = cre_date;
    }

	public long getRefresh() {
		return refresh;
	}

	public void setRefresh(long refresh) {
		this.refresh = refresh;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
    
    
}
