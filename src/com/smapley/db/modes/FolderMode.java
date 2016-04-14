package com.smapley.db.modes;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.File;
import com.smapley.bean.Folder;
import com.smapley.db.entity.FileEntity;
import com.smapley.db.entity.FolderEntity;
import com.smapley.db.service.XDAO;

public class FolderMode {

	private FolderEntity folderEntity;
	private List<FileEntity> listFileEntities;
	private List<FolderMode> folderModes;

	@SuppressWarnings("unchecked")
	public FolderMode(Folder folder, long time) {
		if (folder.getRefresh().getTime() > time)
			folderEntity = new FolderEntity(folder);
		listFileEntities = new ArrayList<FileEntity>();
		for (File file : (List<File>) XDAO.fileDAO.findByProperty("folder",
				folder)) {
			if (file.getRefresh().getTime() > time)
				listFileEntities.add(new FileEntity(file));
		}
		folderModes = new ArrayList<FolderMode>();
		for (Folder folder1 : (List<Folder>) XDAO.folderDAO.findByProperty(
				"folder", folder)) {
			folderModes.add(new FolderMode(folder1, time));
		}

	}

	public FolderEntity getFolderEntity() {
		return folderEntity;
	}

	public void setFolderEntity(FolderEntity folderEntity) {
		this.folderEntity = folderEntity;
	}

	public List<FileEntity> getListFileEntities() {
		return listFileEntities;
	}

	public void setListFileEntities(List<FileEntity> listFileEntities) {
		this.listFileEntities = listFileEntities;
	}

	public List<FolderMode> getFolderModes() {
		return folderModes;
	}

	public void setFolderModes(List<FolderMode> folderModes) {
		this.folderModes = folderModes;
	}

}
