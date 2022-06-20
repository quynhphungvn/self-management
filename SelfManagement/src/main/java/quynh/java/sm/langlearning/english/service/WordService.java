package quynh.java.sm.langlearning.english.service;

import java.util.List;

import quynh.java.sm.langlearning.english.dao.WordDAO;
import quynh.java.sm.langlearning.english.model.Word;

public class WordService {
	private WordDAO wordDAO = new WordDAO();
	
	public List<Word> getWordKnowns(int userId) {
		return wordDAO.getWordKnowns(userId);
	}

	public int addWordToWordKnown(String word, int userId) {
		return wordDAO.addWordToWordKnown(word, userId);
	}
}
