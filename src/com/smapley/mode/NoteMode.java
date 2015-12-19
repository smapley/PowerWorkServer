package com.smapley.mode;

import java.util.ArrayList;
import java.util.List;

import com.smapley.bean.Note;
import com.smapley.bean.NoteDetails;
import com.smapley.entity.NoteDetailsEntity;
import com.smapley.entity.NoteEntity;

public class NoteMode {

	private NoteEntity noteEntity;

	private List<NoteDetailsEntity> listnoteDetailsEntities;

	public NoteMode() {

	}

	public NoteMode(Note note, long time) {
		if (note.getRefresh().getTime() > time)
			noteEntity = new NoteEntity(note);

		listnoteDetailsEntities = new ArrayList<NoteDetailsEntity>();
		for (NoteDetails noteDetails : note.getNoteDetailses()) {
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