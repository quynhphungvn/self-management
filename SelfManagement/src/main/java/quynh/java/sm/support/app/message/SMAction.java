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
	DELETE_VIDEO
	;
	public String getStatus() {
		return this.name();
	}
}
