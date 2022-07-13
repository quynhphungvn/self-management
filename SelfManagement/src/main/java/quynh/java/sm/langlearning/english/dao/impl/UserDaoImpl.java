package quynh.java.sm.langlearning.english.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quynh.java.sm.langlearning.english.dao.UserDao;
import quynh.java.sm.langlearning.english.model.User;
import quynh.java.sm.support.db.util.JDBCConnect;

public class UserDaoImpl implements UserDao{
	private Connection conn;
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public User find(int id) {
		String sql = "select id, username, password from user where id = ?";
		PreparedStatement pstm = null;
		User user = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				pstm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public User find(String username) {
		String sql = "select id, username, password from user where username = ?";
		PreparedStatement pstm = null;
		User user = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				pstm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}
}
