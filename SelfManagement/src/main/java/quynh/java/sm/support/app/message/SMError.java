package quynh.java.sm.support.app.message;

public enum SMError {
	UNKOWN_ERROR,
	PARAM_INVALID,
	RECORD_DUPLICATE,
	RECORD_NOT_EXIST;
	public String getStatus() {
		return this.name();
	}
}
