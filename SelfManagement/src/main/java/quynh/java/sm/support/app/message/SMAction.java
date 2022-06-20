package quynh.java.sm.support.app.message;

public enum SMAction {
	GET,
	GETS,
	ADD,
	ADDS,
	DELETE,
	DELETES,
	UPDATE,
	UPDATES,
	ADD_VIDEO_GROUP,
	DELETE_VIDEO_GROUP,
	GET_VIDEOS_BY_GROUP_ID,
	ADD_VIDEO,
	GET_VIDEO_BY_ID,
	UPDATE_VIDEO,
	DELETE_VIDEO,
	GET_WORDKNOWNS,
	ADD_WORD_TO_WORD_KNOWN,
	UPDATE_VIDEO_VIEW_COUNT
	;
	public String getStatus() {
		return this.name();
	}
}
