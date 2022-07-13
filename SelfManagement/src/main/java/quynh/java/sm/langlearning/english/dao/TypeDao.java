package quynh.java.sm.langlearning.english.dao;

import java.util.List;

import quynh.java.sm.langlearning.english.model.Type;

public interface TypeDao {
	public List<Type> getAll();
	public Type find(int typeId);
	public Type find(String typeName);
	public int add(Type type);
}
