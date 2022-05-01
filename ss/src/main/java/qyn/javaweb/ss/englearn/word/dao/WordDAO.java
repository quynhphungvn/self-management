package qyn.javaweb.ss.englearn.word.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import qyn.javaweb.ss.englearn.word.model.Word;
import qyn.javaweb.ss.util.DBSupport;
import qyn.javaweb.ss.util.Status;

public class WordDAO {
	public static Status addWord(Word word) {
		Connection conn = null;
		Statement stm = null;
		String sql = "insert into word (word) values('" + word.getWord() + "');";
		try {
			conn = DBSupport.getMySQLConnection();
			stm = conn.createStatement();
			int result = stm.executeUpdate(sql);
			if (result == 1) {
				return Status.ADD_SUCCESS;
			} else 
					return Status.ADD_FAIL;
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

	public static Word getWordById(int id) {
		Connection conn = null;
		Statement stm = null;
		Word word = null;
		String sql = "select * from word where id=" + id + ";";
		try {
			conn = DBSupport.getMySQLConnection();
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				word = new Word();
				word.setId(rs.getInt(1));
				word.setWord(rs.getString(2));
			} 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return word;
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
		return word;	
	}
	public static Word getWordByContent(String content) {
		Connection conn = null;
		Statement stm = null;
		Word word = null;
		String sql = "select * from word where word='" + content + "';";
		try {
			conn = DBSupport.getMySQLConnection();
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				word = new Word();
				word.setId(rs.getInt(1));
				word.setWord(rs.getString(2));
			} 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return word;
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
		return word;	
	}
}
