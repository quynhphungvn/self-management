package quynh.java.sm.langlearning.english.service.impl;

import java.sql.Connection;
import java.util.List;

import quynh.java.sm.langlearning.english.dao.impl.WordDAO;
import quynh.java.sm.langlearning.english.model.WordLearning;

public class WordService {
	private WordDAO wordDAO = new WordDAO();
	
	public List<WordLearning> getWordsKnown(Connection conn, int userId) {
		return wordDAO.findWordManagesByState(conn, true, userId);
	}

	public int addWordToManage(Connection conn, String word, int userId, boolean isKnown) {
		return wordDAO.addWordToManage(conn, word, userId, isKnown);
	}
}
