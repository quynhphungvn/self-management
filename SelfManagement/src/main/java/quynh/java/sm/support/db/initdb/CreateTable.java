package quynh.java.sm.support.db.initdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import quynh.java.sm.support.db.util.JDBCConnect;

public class CreateTable {
	public void createAllTable() {
		Connection conn = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sqlIpaSymbol = "create table if not exists symbol("
					+ " id int not null auto_increment,"
					+ "	content varchar(10) not null,"
					+ "	example varchar(20),"
					+ "	example_phonetic varchar(20),"
					+ "	video_guide_url varchar(100),"
					+ "	image_guide_url varchar(100),"
					+ "	type_id int,"
					+ " primary key (id))";
			this.createTable(sqlIpaSymbol, conn);
			
			String sqlGroupVideo = "create table if not exists all_group("
					+ "id int not null auto_increment,"	
					+ "name varchar(100) not null,"
					+ "user_id int,"
					+ "type_id int,"
					+ "unique (name, user_id, type_id),"
					+ "primary key (id))";
			this.createTable(sqlGroupVideo, conn);
			
			String sqlVideoLearning = "create table if not exists video("
					+ "id int not null auto_increment,"
					+ "title varchar(100) not null,"
					+ "url varchar(100) not null,"
					+ "subtitle text,"
					+ "group_id int not null,"
					+ "view_count int,"
					+ "unique (url, group_id),"
					+ "primary key (id))";
			this.createTable(sqlVideoLearning, conn);
		
			String sqlUser = "create table if not exists user("
					+ "id int not null auto_increment,"
					+ "username varchar(100) not null unique,"
					+ "password varchar(32) not null,"
					+ "primary key (id))";
			this.createTable(sqlUser, conn);
			
			String sqlDictionary = "create table if not exists dictionary("
					+ "id int not null auto_increment,"
					+ "content varchar(25) not null unique,"
					+ "phonetic varchar(20),"
					+ "user_id int,"
					+ "primary key (id))";
			this.createTable(sqlDictionary, conn);
			
			String sqlWordManage = "create table if not exists word_learning("
					+ "id int not null auto_increment,"
					+ "word_id int,"
					+ "user_id int,"
					+ "known_state boolean,"
					+ "appear int,"
					+ "unique (word_id, user_id),"
					+ "primary key (id))";
			this.createTable(sqlWordManage, conn);
			
			String sqlPronun = "create table if not exists pronunciation_learning("
					+ "id int not null auto_increment,"					
					+ "symbol_id int,"
					+ "user_id int,"
					+ "view_count int,"
					+ "primary key (id))";
			this.createTable(sqlPronun, conn);
			
			String sqlType = "create table if not exists type("
					+ "id int not null auto_increment,"					
					+ "name varchar(20) unique,"
					+ "primary key (id))";
			this.createTable(sqlType, conn);
			
			String sqlTempWord = "create table if not exists temp_word("
					+ "id int not null auto_increment,"
					+ "content varchar(25),"
					+ "user_id int,"					
					+ "unique (content, user_id),"
					+ "primary key (id))";
			this.createTable(sqlTempWord, conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int createTable(String sql, Connection conn) {
		int result = 0;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			result = pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		CreateTable ct = new CreateTable();
		ct.createAllTable();
		System.out.println("OK");
	}
}
