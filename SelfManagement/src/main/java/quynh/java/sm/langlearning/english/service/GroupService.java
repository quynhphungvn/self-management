package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dto.GroupDto;
import quynh.java.sm.langlearning.english.model.Group;

public interface GroupService {
	List<GroupDto> getAll(int userId, String type);
	Group deleteGroup(int groupId, int userId);
	Group addGroup(String groupName, String groupType, int userId);
}
