package quynh.java.sm.langlearning.english.dao;

import quynh.java.sm.langlearning.english.model.User;

public interface UserDao {
	public abstract User find(int id);
	public abstract User find(String username);
}
