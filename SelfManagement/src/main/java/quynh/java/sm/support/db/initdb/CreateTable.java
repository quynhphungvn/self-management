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
					+ "	symbol varchar(10) not null,"
					+ "	example varchar(20),"
					+ "	example_phonetic varchar(20),"
					+ "	video_guide_url varchar(100),"
					+ "	image_guide_url varchar(100),"
					+ "	type varchar(20),"
					+ " primary key (id))";
			this.createTable(sqlIpaSymbol, conn);
			
			String sqlGroupVideo = "create table if not exists video_group ("
					+ "id int not null auto_increment,"
					+ "user_id int,"
					+ "name varchar(30) not null unique,"
					+ "primary key (id))";
			this.createTable(sqlGroupVideo, conn);
			
			String sqlVideoLearning = "create table if not exists video("
					+ "id int not null auto_increment,"
					+ "title varchar(100) not null,"
					+ "url varchar(100) not null,"
					+ "subtitle text,"
					+ "group_id int not null,"
					+ "primary key (id))";
			this.createTable(sqlVideoLearning, conn);
			
			String sqlVideoViewInfo = "create table if not exists video_view_info("
					+ "id int not null auto_increment,"
					+ "user_id int,"
					+ "video_id,"
					+ "view_count int,"
					+ "primary key (id))";
			this.createTable(sqlVideoViewInfo, conn);
			
			String sqlUser = "create table if not exists user("
					+ "id int not null auto_increment,"
					+ "username varchar(100) not null unique,"
					+ "password varchar(32) not null,"
					+ "primary key (id))";
			this.createTable(sqlUser, conn);
			
			String sqlDictionary = "create table if not exists dictionary("
					+ "id int not null auto_increment,"
					+ "word varchar(25) not null unique,"
					+ "phonetic varchar(20),"
					+ "primary key (id))";
			this.createTable(sqlDictionary, conn);
			
			String sqlWordKnown = "create table if not exists word_known("
					+ "id int not null auto_increment,"
					+ "word_id int,"
					+ "user_id int,"
					+ "primary key (id))";
			this.createTable(sqlWordKnown, conn);
			
			String sqlSymbolViewInfo = "create table if not exists symbol_view_info("
					+ "id int not null auto_increment,"
					+ "user_id int,"
					+ "symbol_id int,"
					+ "view_count int,"
					+ "primary key (id))";
			this.createTable(sqlSymbolViewInfo, conn);
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
	public void main(String[] args) {
		CreateTable ct = new CreateTable();
		ct.createAllTable();
	}
}
