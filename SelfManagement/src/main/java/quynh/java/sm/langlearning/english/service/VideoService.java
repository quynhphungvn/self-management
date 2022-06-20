package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dao.VideoDAO;
import quynh.java.sm.langlearning.english.dao.VideoGroupDAO;
import quynh.java.sm.langlearning.english.dao.WordDAO;
import quynh.java.sm.langlearning.english.model.Video;

public class VideoService {
	public VideoDAO videoDAO = new VideoDAO();
	public VideoGroupDAO videoGroupDAO = new VideoGroupDAO();
	public WordDAO wordDAO = new WordDAO();
	
	public Video addVideo(Video video) {
		Video videoAdded = null;
		Video videoCheck = videoDAO.getVideoByUrl(video.getUrl(), video.getGroupId(), video.getUserId());
		if (videoCheck == null) {
			int result = videoDAO.addVideo(video);
			if (result == 1) {
				videoAdded = videoDAO.getVideoByUrl(video.getUrl(), video.getGroupId(), video.getUserId());
			}
		}
		return videoAdded;
	}
	public List<Video> getVideosByGroupId(int groupId, int userId) {
		return videoDAO.getVideosByGroupId(groupId, userId);
	}

	public Video getVideoById(int videoId, int userId) {
		return videoDAO.getVideoById(videoId, userId);
	}

	public int updateVideo(Video video) {
		return videoDAO.updateVideo(video);		
	}

	public int deleteVideo(int id) {
		return videoDAO.deleteVideoById(id);
	}
	public int updateVideoViewCount(int videoId, int userId) {
		return videoDAO.updateVideoViewCount(videoId, userId);
		
	}
}
