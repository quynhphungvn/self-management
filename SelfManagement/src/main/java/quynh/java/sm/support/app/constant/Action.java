package quynh.java.sm.support.app.constant;

public enum Action {
	ADD_POST,
	UPDATE_POST,
	DELETE_POST,
	GET_ALL_POST_INFO,
	GET_POST_CONTENT_BY_ID,
	ADD_NOTE,
	DELETE_NOTE,
	GET_ALL_WORD_KNOWN,
	ADD_WORD_TO_WORD_KNOWN;
	public String getStatus() {
		return this.name();
	}
}
