package quynh.java.sm.support.db.initdb;

import java.sql.Connection;
import java.sql.SQLException;

import quynh.java.sm.langlearning.english.dao.TypeDao;
import quynh.java.sm.langlearning.english.dao.impl.TypeDaoImpl;
import quynh.java.sm.langlearning.english.model.Type;
import quynh.java.sm.support.db.util.JDBCConnect;

public class InitType {
	private Connection conn;
	public InitType() {
		try {
			conn = JDBCConnect.getMySQLConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initType() {
		TypeDao typeDao = new TypeDaoImpl(conn);
		String[] types = {"video", "document", "vowel", "consonant", "r-colored-vowel", "diphthong"};
		for (String s : types) {
			typeDao.add(new Type(0, s));
		}
	}
	public static void main(String[] args) {
		InitType initType = new InitType();
		initType.initType();
	}
}
