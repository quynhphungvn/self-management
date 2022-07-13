package quynh.java.sm.langlearning.english.dao;

import quynh.java.sm.langlearning.english.model.Word;

public interface DictionaryDao {
	public abstract Word find(int wordId);
	public abstract Word find(String content);
	public abstract int add(Word word);
	public abstract int update(Word word);
	public abstract int delete(int wordId);
}
