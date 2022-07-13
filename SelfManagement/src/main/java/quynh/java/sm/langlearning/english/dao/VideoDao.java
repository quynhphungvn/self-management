package quynh.java.sm.langlearning.english.dao;

import java.util.List;

import quynh.java.sm.langlearning.english.model.Video;

public interface VideoDao {
	public List<Video> getAll(int groupId);
	public abstract Video find(int id);
	public abstract Video find(String videoUrl, int groupId);
	public abstract int add(Video video);
	public abstract int update(Video video);
	public abstract int delete(int id);
}
