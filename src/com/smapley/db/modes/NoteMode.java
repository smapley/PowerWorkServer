package com.smapley.db.modes;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.Note;
import com.smapley.bean.NoteDetails;
import com.smapley.db.entity.NoteDetailsEntity;
import com.smapley.db.entity.NoteEntity;
import com.smapley.db.service.XDAO;

public class NoteMode {

	private NoteEntity noteEntity;

	private List<NoteDetailsEntity> listnoteDetailsEntities;

	public NoteMode() {

	}

	@SuppressWarnings("unchecked")
	public NoteMode(Note note, long time) {
		if (note.getRefresh().getTime() > time)
			noteEntity = new NoteEntity(note);

		listnoteDetailsEntities = new ArrayList<NoteDetailsEntity>();
		for (NoteDetails noteDetails : (List<NoteDetails>) XDAO.noteDetailsDAO
				.findByProperty("note", note)) {
			if (noteDetails.getRefresh().getTime() > time)
				listnoteDetailsEntities.add(new NoteDetailsEntity(noteDetails));
		}
	}

	public NoteEntity getNoteEntity() {
		return noteEntity;
	}

	public void setNoteEntity(NoteEntity noteEntity) {
		this.noteEntity = noteEntity;
	}

	public List<NoteDetailsEntity> getListnoteDetailsEntities() {
		return listnoteDetailsEntities;
	}

	public void setListnoteDetailsEntities(
			List<NoteDetailsEntity> listnoteDetailsEntities) {
		this.listnoteDetailsEntities = listnoteDetailsEntities;
	}

}