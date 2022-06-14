package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dao.VideoDAO;
import quynh.java.sm.langlearning.english.model.Video;
import quynh.java.sm.support.app.message.SMError;
import quynh.java.sm.support.app.message.SMMessage;
import quynh.java.sm.support.app.message.SMStatus;

public class VideoService {
	public VideoDAO videoDAO = new VideoDAO();
	
	public SMMessage addVideo(Video v) {
		SMMessage smm = new SMMessage();
		int resultAdd = videoDAO.addVideo(v);
		if (resultAdd == 1) {
			smm.setStatus(SMStatus.SUCCESS.getStatus());
		}
		else {
			smm.setStatus(SMStatus.FAIL.getStatus());
			smm.setData(SMError.UNKOWN_ERROR.getStatus());
		}
		return smm;
	}
	public SMMessage getVideosByGroupId(int groupId, int userId) {
		SMMessage smm = new SMMessage();
		List<Video> result = videoDAO.getVideosByGroupId(groupId, userId);
		if (result != null) {
			smm.setStatus(SMStatus.SUCCESS.getStatus());
			smm.setData(result);
		}
		else {
			smm.setStatus(SMStatus.FAIL.getStatus());
			smm.setData(SMError.UNKOWN_ERROR.getStatus());
		}
		return smm;
	}
}
