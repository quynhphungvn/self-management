package quynh.java.sm.support.db.initdb;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import quynh.java.sm.langlearning.english.dao.impl.DictionaryDaoImpl;
import quynh.java.sm.support.db.util.JDBCConnect;

public class WordDB {
	private Connection conn;
	private DictionaryDaoImpl wordDao;
	public WordDB() {
		wordDao = new DictionaryDaoImpl();
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
	public List<String> readFile(String filePath) {     
	    ArrayList<String> wordList = new ArrayList<String>(); 
	    try {
	        File myFile = new File(filePath);
	        Scanner myReader = new Scanner(myFile);
	        while (myReader.hasNextLine()) {
	          String[] data = myReader.nextLine().split(" ");
	          for (String s : data)
	          wordList.add(s);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	    return wordList;
	}
	public void initDictionaryTable(Connection conn) {
		String filePath ="src/main/resources/engwords.txt";	
		List<String> words = this.readFile(filePath);
		try {
			String sql = "insert into dictionary(content, user_id) values (?, 0);";
			String sqlCheckExist = "select id from dictionary where word=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			PreparedStatement pstmCheckExist = conn.prepareStatement(sqlCheckExist);
			for (String s: words) {
				pstmCheckExist.setString(1, s);
				ResultSet rs =  pstmCheckExist.executeQuery();
				if (!rs.next()) {
					pstm.setString(1, s);
					pstm.executeUpdate();
					System.out.println(s);
				} 
				else System.out.println(s + " existed!");	
			}
			pstm.close();
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
	public void initWordKnown() {
		String filePath ="src/main/resources/wordknown.txt";	
		List<String> wordsRaw = this.readFile(filePath);
		List<String> words = new ArrayList<String>();
		for (String word : wordsRaw)
		{
			if (!findWordInList(word, words))
				words.add(word);
		}
		for (String s : words) {
			//wordDao.addWordToManage(conn, s, 1, true);
		}
	}
	public boolean findWordInList(String word, List<String> wordList) {
		for (String s : wordList) 
			if (s.equals(word)) return true;
		return false;
	}
	public static void main(String[] args) {
		WordDB ddb = new WordDB();
		ddb.initWordKnown();
	}
}
