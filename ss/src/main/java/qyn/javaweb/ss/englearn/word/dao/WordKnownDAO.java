package qyn.javaweb.ss.englearn.word.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.englearn.word.model.Word;
import qyn.javaweb.ss.englearn.word.model.WordKnown;
import qyn.javaweb.ss.util.DBSupport;
import qyn.javaweb.ss.util.Status;

public class WordKnownDAO {
	public static List<WordKnown> getAllWordKnown() {
		Connection conn = null;
		Statement stm = null;
		List<WordKnown> lWordKnown = new ArrayList<WordKnown>();
		String sql = "select word_known.id, word.id, word.word from word_known, word where word.id = word_known.word_id order by word.word;";
		try {
			conn = DBSupport.getMySQLConnection();
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				WordKnown wordKnown = new WordKnown();
				wordKnown.setWordKnownId(rs.getInt(1));
				Word word = new Word();
				word.setId(rs.getInt(2));
				word.setWord(rs.getString(3));
				wordKnown.setWord(word);
				lWordKnown.add(wordKnown);
			} 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stm != null)
					stm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lWordKnown;
	}
	public static Status addWordKnown(WordKnown wordKnown) {
		Connection conn = null;
		Statement stm = null;
		try {
			Word wordTest = WordDAO.getWordByContent(wordKnown.getWord().getWord());
			if (wordTest == null) {
				WordDAO.addWord(wordKnown.getWord());
				Word wordInserted = WordDAO.getWordByContent(wordKnown.getWord().getWord());
				String sql = "insert into word_known (word_id) values(" + wordInserted.getId() + ");";
				conn = DBSupport.getMySQLConnection();
				stm = conn.createStatement();
				int result = stm.executeUpdate(sql);
				if (result == 1)
					return Status.ADD_SUCCESS;
				else return Status.ADD_FAIL;
			}
			else {
				Word wordInserted = WordDAO.getWordByContent(wordKnown.getWord().getWord());
				String sql = "insert into word_known (word_id) values(" + wordInserted.getId() + ");";
				conn = DBSupport.getMySQLConnection();
				stm = conn.createStatement();
				int result = stm.executeUpdate(sql);
				if (result == 1)
					return Status.ADD_SUCCESS;
				else return Status.ADD_FAIL;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Status.ADD_FAIL;
		} finally {
				try {
					if (stm != null)
						stm.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
