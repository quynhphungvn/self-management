package quynh.java.sm.langlearning.english.service.impl;

import java.util.List;

import quynh.java.sm.langlearning.english.dao.impl.VideoDaoImpl;
import quynh.java.sm.langlearning.english.dao.impl.GroupDaoImpl;
import quynh.java.sm.langlearning.english.model.Group;

public class VideoServiceImpl {
	private GroupDaoImpl videoGroupDAO = new GroupDaoImpl();
	private VideoDaoImpl videoDAO = new VideoDaoImpl();
	
	public List<Group> getVideoGroupsByUserId(int userId) {
		return videoGroupDAO.getGroupsByUserId(userId);
	}
	public Group addVideoGroup(Group videoGroup) {
		Group group = null;
		Group v = videoGroupDAO.getGroupByName(videoGroup.getUserId(), videoGroup.getName());
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
	public int deleteVideoGroup(Group videoGroup) {
		Group v = videoGroupDAO.getGroupByName(videoGroup.getUserId(), videoGroup.getName());
		int result = 0;
		if (v != null)
		{
			videoDAO.deleteVideosByGroupId(v.getId());
			result = videoGroupDAO.deleteGroupByName(videoGroup.getUserId(), videoGroup.getName());
		}
		return result;
	}
	public List<Group> getGroups(int userId, String type) {
		// TODO Auto-generated method stub
		return null;
	}
}
