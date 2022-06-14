package quynh.java.sm.langlearning.english.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quynh.java.sm.langlearning.english.model.Video;
import quynh.java.sm.support.db.util.JDBCConnect;

public class VideoDAO {
	
	public int addVideo(Video v) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "insert into video (title, url, subtitle, group_id, user_id, view_count) values(?,?,?,?,?,?);";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, v.getTitle());
			pstm.setString(2, v.getUrl());
			pstm.setInt(4, v.getGroupId());
			pstm.setString(3, v.getSubtitle());
			pstm.setInt(5, v.getUserId());
			pstm.setInt(6, v.getViewCount());
			result = pstm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Video> getVideosByGroupId (int groupId, int userId) {
		Connection conn = null;
		List<Video> lVideo = new ArrayList<Video>();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select id, title, url, subtitle, view_count from video where group_id=? and user_id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, groupId);
			pstm.setInt(2, userId);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Video v = new Video();
				v.setId(rs.getInt(1));
				v.setTitle(rs.getString(2));
				v.setUrl(rs.getString(3));
				v.setSubtitle(rs.getString(4));
				v.setGroupId(groupId);
				v.setUserId(userId);
				v.setViewCount(rs.getInt(5));
				lVideo.add(v);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lVideo;
	}
	
	public int deleteVideosByGroupId(int groupId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "delete from video where group_id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, groupId);
			result = pstm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
