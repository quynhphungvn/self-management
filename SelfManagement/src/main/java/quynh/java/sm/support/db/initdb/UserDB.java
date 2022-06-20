package quynh.java.sm.support.db.initdb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import quynh.java.sm.support.db.util.JDBCConnect;

public class UserDB {
	public static int initUser() {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "insert into user (username, password) values ('quynh', '1');";
			Statement stm = conn.createStatement();
			result = stm.executeUpdate(sql);
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
		return result;
	}
	public static void main(String[] args) {
		int result = initUser();
		if (result == 1)
			System.out.print("Ok");
		else 
			System.out.print("Fail");
	}
}
