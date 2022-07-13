package quynh.java.sm.langlearning.english.dao;

import quynh.java.sm.langlearning.english.model.SymbolLearning;

public interface SymbolLearningDao {
	public SymbolLearning find(int symbolId, int userId);
	public int updateViewCount(int symbolId, int userId);
	public int add(int symbolId, int userId, int viewCount);
}
