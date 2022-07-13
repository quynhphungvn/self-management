package quynh.java.sm.support.app.message;

import com.google.gson.Gson;

public class ResponseCreator {
	private Gson gson;
	
	public ResponseCreator() {
		gson = new Gson();
	}
	public String createJsonResponseMessage(String respCode, Object data) {
		ResponseMessage mes = new ResponseMessage();
		mes.setStatus(respCode);
		mes.setData(data);
		return gson.toJson(mes);
	}
}
