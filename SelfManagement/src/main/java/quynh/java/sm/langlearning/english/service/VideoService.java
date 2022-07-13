package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dto.VideoBasicDto;
import quynh.java.sm.langlearning.english.dto.VideoDetailDto;

public interface VideoService {
	List<VideoBasicDto> getVideos(int groupId, int userId);
	VideoDetailDto getVideo(int videoId, int userId);
	int addVideo(VideoDetailDto v, int userId);
	int updateVideo(VideoDetailDto v, int userId);
	int deleteVideo(int videoId, int userId);
}
