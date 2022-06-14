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
	DELETE_VIDEO_GROUP
	;
	public String getStatus() {
		return this.name();
	}
}
