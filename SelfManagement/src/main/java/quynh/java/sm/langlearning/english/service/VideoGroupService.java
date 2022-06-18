package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dao.VideoDAO;
import quynh.java.sm.langlearning.english.dao.VideoGroupDAO;
import quynh.java.sm.langlearning.english.model.VideoGroup;

public class VideoGroupService {
	private VideoGroupDAO videoGroupDAO = new VideoGroupDAO();
	private VideoDAO videoDAO = new VideoDAO();
	
	public List<VideoGroup> getVideoGroupsByUserId(int userId) {
		return videoGroupDAO.getGroupsByUserId(userId);
	}
	public VideoGroup addVideoGroup(VideoGroup videoGroup) {
		VideoGroup group = null;
		VideoGroup v = videoGroupDAO.getGroupByName(videoGroup.getUserId(), videoGroup.getName());
		if (v != null)
			return null;
		else {
			int resultAdd = videoGroupDAO.addGroup(videoGroup.getUserId(), videoGroup.getName());
			if (resultAdd == 1) {
				group = videoGroupDAO.getGroupByName(videoGroup.getUserId(), videoGroup.getName());
			}				
		}
		return group;
	}
	public int deleteVideoGroup(VideoGroup videoGroup) {
		VideoGroup v = videoGroupDAO.getGroupByName(videoGroup.getUserId(), videoGroup.getName());
		int result = 0;
		if (v != null)
		{
			videoDAO.deleteVideosByGroupId(v.getId());
			result = videoGroupDAO.deleteGroupByName(videoGroup.getUserId(), videoGroup.getName());
		}
		return result;
	}
}
