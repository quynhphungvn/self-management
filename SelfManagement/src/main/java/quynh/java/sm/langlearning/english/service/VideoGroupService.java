package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dao.VideoDAO;
import quynh.java.sm.langlearning.english.dao.VideoGroupDAO;
import quynh.java.sm.langlearning.english.model.VideoGroup;

public class VideoGroupService {
	private VideoGroupDAO videoGroupDAO = new VideoGroupDAO();
	private VideoDAO videoDAO = new VideoDAO();
	
	public List<VideoGroup> getVideoGroupsByUserId(int userId) {
		return videoGroupDAO.getVideoGroupsByUserId(userId);
	}
	public int addVideoGroup(VideoGroup videoGroup) {
		VideoGroup v = videoGroupDAO.getVideoGroupByName(videoGroup.getUserId(), videoGroup.getName());
		if (v != null)
			return 0;
		else
			return videoGroupDAO.addVideoGroup(videoGroup.getUserId(), videoGroup.getName());
	}
	public int deleteVideoGroup(VideoGroup videoGroup) {
		VideoGroup v = videoGroupDAO.getVideoGroupByName(videoGroup.getUserId(), videoGroup.getName());
		int result = 0;
		if (v != null)
		{
			videoDAO.deleteVideosByGroupId(v.getId());
			result = videoGroupDAO.deleteVideoGroupByName(videoGroup.getUserId(), videoGroup.getName());
		}
		return result;
	}
}
