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

import quynh.java.sm.support.db.util.JDBCConnect;

public class WordDB {
	public List<String> readFile() {
		String file ="src/main/resources/engwords.txt";	     
	    ArrayList<String> wordList = new ArrayList<String>(); 
	    try {
	        File myFile = new File(file);
	        Scanner myReader = new Scanner(myFile);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          wordList.add(data);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	    return wordList;
	}
	public void initWordTable() {
		List<String> words = this.readFile();
		Connection conn = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "insert into word (word, user_add) values (?, false);";
			String sqlCheckExist = "select id from word where word=?";
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
		} catch (ClassNotFoundException | SQLException e) {
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
	public static void main(String[] args) {
		WordDB ddb = new WordDB();
		ddb.initWordTable();
	}
}
