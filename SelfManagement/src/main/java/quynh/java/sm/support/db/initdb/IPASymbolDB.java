package quynh.java.sm.support.db.initdb;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import quynh.java.sm.support.db.util.JDBCConnect;

public class IPASymbolDB {
	public List<String> readFile() {
		String file ="src/main/resources/ipa-symbol.txt";	     
	    List<String> symbols = new ArrayList<String>(); 
	    try {
	        File myFile = new File(file);
	        Scanner myReader = new Scanner(myFile);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          symbols.add(data);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	    return symbols;
	}
	public void initIpaSymbol() {
		List<String> symbols = this.readFile();
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = JDBCConnect.getMySQLConnection();			
			String sql = "insert into ipa_symbol (symbol, example, example_phonetic, image_guide_url, video_guide_url, type) "
					+ "values (?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);		
			for (String s: symbols) {
				String[] symbolParts = s.split(","); 
				pstm.setString(1, symbolParts[0].trim());
				pstm.setString(2, symbolParts[1].trim());
				pstm.setString(3, symbolParts[2].trim());
				pstm.setString(4, symbolParts[3].trim());
				pstm.setString(5, symbolParts[4].trim());
				pstm.setString(6, symbolParts[5].trim());
				pstm.executeUpdate();
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		IPASymbolDB idb = new IPASymbolDB();
		idb.initIpaSymbol();
	}
}
