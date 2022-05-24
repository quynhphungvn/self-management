package qyn.javaweb.ss.note.model;

import java.util.Date;

public class Note {
	private int noteId;
	private String noteContent;
	private String noteComment;
	private Date noteTimeAdded;
	private Priority notePriority;
	private NoteType noteType;
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
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
	public Priority getNotePriority() {
		return notePriority;
	}
	public void setNotePriority(Priority notePriority) {
		this.notePriority = notePriority;
	}
	public NoteType getNoteType() {
		return noteType;
	}
	public void setNoteType(NoteType noteType) {
		this.noteType = noteType;
	}
}
