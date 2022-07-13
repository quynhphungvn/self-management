package quynh.java.sm.langlearning.english.dao;

import java.util.List;

import quynh.java.sm.langlearning.english.model.Group;

public interface GroupDao {
	public List<Group> findAll(int userId, int type);
	public Group find(int groupId);
	public Group find(String groupName, int type, int userId);
	public int add(String groupName);
	public int delete(int groupId);
}
