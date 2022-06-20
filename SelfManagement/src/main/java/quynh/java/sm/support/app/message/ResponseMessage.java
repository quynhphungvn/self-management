package quynh.java.sm.support.app.message;

public class ResponseMessage {
	public SMMessage createResponseMessage(SMStatus status, Object data) {
		SMMessage mes = new SMMessage();
		mes.setStatus(status.getStatus());
		mes.setData(data);
		return mes;
	}
}
