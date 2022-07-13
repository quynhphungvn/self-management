package quynh.java.sm.support.app.message;

import lombok.Data;

@Data
public class ResponseMessage {
	private String status;
	private Object data;
}
