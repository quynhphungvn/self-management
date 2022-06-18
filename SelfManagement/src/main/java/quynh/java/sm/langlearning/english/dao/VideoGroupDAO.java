package quynh.java.sm.langlearning.english.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import quynh.java.sm.langlearning.english.model.VideoGroup;
import quynh.java.sm.support.db.util.JDBCConnect;

public class VideoGroupDAO {
	
	public List<VideoGroup> getGroupsByUserId(int userId) {
		Connection conn = null;
		List<VideoGroup> listVideoGroup = new ArrayList<VideoGroup>();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select id, user_id, name from video_group where user_id=?;";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				VideoGroup videoGroup = new VideoGroup();
				videoGroup.setId(rs.getInt(1));
				videoGroup.setUserId(rs.getInt(2));
				videoGroup.setName(rs.getString(3));
				listVideoGroup.add(videoGroup);
			}
			pstm.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return listVideoGroup;
	}
	public VideoGroup getGroupByName(int userId, String groupName) {
		Connection conn = null;
		VideoGroup videoGroup = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select id, user_id, name from video_group where user_id=? and name=?;";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			pstm.setString(2, groupName);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				videoGroup = new VideoGroup();
				videoGroup.setId(rs.getInt(1));
				videoGroup.setUserId(rs.getInt(2));
				videoGroup.setName(rs.getString(3));
			}
			pstm.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return videoGroup;
	}
	public int addGroup(int userId, String groupName) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "insert into video_group(user_id, name) values(?,?);";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			pstm.setString(2, groupName);
			result = pstm.executeUpdate();
			pstm.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}
	public int deleteGroupByName(int userId, String groupName) {
		Connection conn = null;
		int result = 0;
		PreparedStatement pstm = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "delete from video_group where user_id=? and name=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			pstm.setString(2, groupName);
			result = pstm.executeUpdate();		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();			
			try {
				pstm.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
		}
		return result;
	}
	public int getGroupIdByGroupName(String groupName, int userId) {
		Connection conn = null;
		int groupId = 0;
		String sql = "select id from video_group where name=? and user_id=?";
		PreparedStatement pstm = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, groupName);
			pstm.setInt(2, userId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				groupId = rs.getInt(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			try {
				pstm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return groupId;
	}
}
																		