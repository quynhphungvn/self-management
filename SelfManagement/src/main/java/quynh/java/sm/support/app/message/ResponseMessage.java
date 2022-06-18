package quynh.java.sm.support.app.message;

public class ResponseMessage {
	public SMMessage createResponseMessage(SMStatus status, Object data) {
		SMMessage mes = new SMMessage();
		if (status == SMStatus.FAIL) {
			mes.setStatus(SMStatus.FAIL.getStatus());
		}
		else {
			mes.setStatus(SMStatus.SUCCESS.getStatus());
			mes.setData(data);
		}
		return mes;
	}
}