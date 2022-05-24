package qyn.javaweb.ss.englearn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.englearn.word.model.Word;
import qyn.javaweb.ss.util.DBSupport;

public class WordDAO {
	public static List<Word> getAllKnownWord() {
		Connection conn = null;
		List<Word> listKnownWord = new ArrayList<Word>();
		try {
			conn = DBSupport.getMySQLConnection();
			String sql = "select word.id, word.word from word inner join word_known on word_known.word_id = word.id";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Word word = new Word();
				word.setId(rs.getInt(1));
				word.setWord(rs.getString(2));
				listKnownWord.add(word);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listKnownWord;
	}
	public static void addToWordKnown(String word) {
		Connection conn = null;
		String sql = "select id from word where word=\""+ word + "\"";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) 
			{
				String sqlAddToWordKnown = "insert into word_known (word_id) values (" + rs.getInt(1) + ");";
				Statement stm1 = conn.createStatement();
				stm1.executeUpdate(sqlAddToWordKnown);
			}
			else {
				String sqlAddToWord = "insert into word (word) values (\"" + word + "\")";
				Statement stm2 = conn.createStatement();
				stm2.executeUpdate(sqlAddToWord);
				Statement stm3 = conn.createStatement();
				ResultSet rs1 = stm3.executeQuery(sql);
				rs1.next();
				String sqlAddToWordKnown = "insert into word_known (word_id) values (" + rs1.getInt(1) + ");";
				Statement stm4 = conn.createStatement();
				stm4.executeUpdate(sqlAddToWordKnown);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
