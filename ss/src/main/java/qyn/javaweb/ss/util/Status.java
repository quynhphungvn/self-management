package qyn.javaweb.ss.util;

public enum Status {	
	PARAM_INVALID,
	GET_SUCCESS,
	GET_FAIL,
	ADD_SUCCESS,
	UPDATE_SUCCESS,
	DELETE_SUCCESS,
	RESOURCE_DUPLICATE,
	RESOURCE_NOT_EXIST,
	ADD_FAIL,
	UPDATE_FAIL,
	DELETE_FAIL;
	
	public String getStatus() {
		return this.name();
	}
}
