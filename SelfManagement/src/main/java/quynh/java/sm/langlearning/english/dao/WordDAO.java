package quynh.java.sm.langlearning.english.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quynh.java.sm.langlearning.english.model.Word;
import quynh.java.sm.support.db.util.JDBCConnect;

public class WordDAO {
	
	public List<Word> getWordKnowns(int userId) {
		Connection conn = null;
		List<Word> wordKnowns = new ArrayList<>();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select word.id, word, phonetic from word, word_review "
					+ "where word_review.user_id = ? "
					+ "and word_review.word_id = word.id "
					+ "and word_review.known = true";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Word word = new Word();
				word.setId(rs.getInt(1));
				word.setWord(rs.getString(2));
				word.setPhonetic(rs.getString(3));
				wordKnowns.add(word);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return wordKnowns;
	}

	public int addWordToWordKnown(String word, int userId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sqlGetWord = "select id from word where word=?";
			PreparedStatement pstm = conn.prepareStatement(sqlGetWord);
			pstm.setString(1, word);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int wordId = rs.getInt(1);
				String sqlCheckWord = "select id from word_review where word_id=? and user_id=? and known=true;";
				PreparedStatement pstmCheckWord = conn.prepareStatement(sqlCheckWord);
				pstmCheckWord.setInt(1, wordId);
				pstmCheckWord.setInt(2, userId);
				ResultSet rsCheckWord = pstmCheckWord.executeQuery();
				if (!rsCheckWord.next()) {
					String sqlAddToWordKnown = "insert into word_review (word_id, user_id, known) values (?, ?, true);";
					PreparedStatement pstmWordKnown = conn.prepareStatement(sqlAddToWordKnown);
					pstmWordKnown.setInt(1, wordId);
					pstmWordKnown.setInt(2, userId);
					result = pstmWordKnown.executeUpdate();
				}
			} else {
				String insertSWord = "insert into word (word, user_add) values (?, true);";
				PreparedStatement pstmInsertSWord = conn.prepareStatement(insertSWord);
				pstmInsertSWord.setString(1, word);
				int resultInsert = pstmInsertSWord.executeUpdate();
				if (resultInsert == 1) {
					String sqlGetId = "select id from word where word=?";
					PreparedStatement pstmGetId = conn.prepareStatement(sqlGetId);
					pstmGetId.setString(1, word);
					ResultSet rsGetId = pstmGetId.executeQuery();
					if (rsGetId.next()) {
						String sqlAddToWordKnown = "insert into word_review (word_id, user_id, known) values (?, ?, true);";
						PreparedStatement pstmWordKnown = conn.prepareStatement(sqlAddToWordKnown);
						pstmWordKnown.setInt(1, rsGetId.getInt(1));
						pstmWordKnown.setInt(2, userId);
						result = pstmWordKnown.executeUpdate();
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
