package qyn.javaweb.ss.note.dto;

import java.util.Date;

public class NoteClientDTO {
	private String noteContent;
	private String noteComment;
	private Date noteTimeAdded;
	private int notePriorityId;
	private int noteTypeId;
	
	public NoteClientDTO(String noteContent, String noteComment, Date noteTimeAdded, int notePriorityId,
			int noteTypeId) {
		super();
		this.noteContent = noteContent;
		this.noteComment = noteComment;
		this.noteTimeAdded = noteTimeAdded;
		this.notePriorityId = notePriorityId;
		this.noteTypeId = noteTypeId;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getNoteComment() {
		return noteComment;
	}
	public void setNoteComment(String noteComment) {
		this.noteComment = noteComment;
	}
	public Date getNoteTimeAdded() {
		return noteTimeAdded;
	}
	public void setNoteTimeAdded(Date noteTimeAdded) {
		this.noteTimeAdded = noteTimeAdded;
	}
	public int getNotePriorityId() {
		return notePriorityId;
	}
	public void setNotePriorityId(int notePriorityId) {
		this.notePriorityId = notePriorityId;
	}
	public int getNoteTypeId() {
		return noteTypeId;
	}
	public void setNoteTypeId(int noteTypeId) {
		this.noteTypeId = noteTypeId;
	}
}
