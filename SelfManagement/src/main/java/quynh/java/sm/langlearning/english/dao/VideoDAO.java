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
			pstm.setString(3, v.getSubtitle());
			pstm.setInt(4, v.getGroupId());
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
	public Video getVideoByUrl(String url, int groupId, int userId) {
			Connection conn = null;
			Video video = null;
			try {
				conn = JDBCConnect.getMySQLConnection();
				String sql = "select id, title, url, subtitle, group_id, user_id, view_count from video where url=? and group_id=? and user_id=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, url);
				pstm.setInt(2, groupId);
				pstm.setInt(3, userId);
				ResultSet rs = pstm.executeQuery();
				if (rs.next()) {
					video = new Video();
					video.setId(rs.getInt(1));
					video.setTitle(rs.getString(2));
					video.setUrl(rs.getString(3));
					video.setSubtitle(rs.getString(4));
					video.setGroupId(rs.getInt(5));
					video.setUserId(rs.getInt(6));
					video.setViewCount(rs.getInt(7));
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return video;
	}
	public Video getVideoById(int videoId, int userId) {
		Connection conn = null;
		Video video = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select id, title, url, subtitle, group_id, user_id, view_count from video where id=? and user_id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, videoId);
			pstm.setInt(2, userId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				video = new Video();
				video.setId(rs.getInt(1));
				video.setTitle(rs.getString(2));
				video.setUrl(rs.getString(3));
				video.setSubtitle(rs.getString(4));
				video.setGroupId(rs.getInt(5));
				video.setUserId(rs.getInt(6));
				video.setViewCount(rs.getInt(7));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return video;
	}

	public int updateVideo(Video video) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "update video set title=?, url=?, subtitle=?, group_id=?, user_id=? where id=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, video.getTitle());
			pstm.setString(2, video.getUrl());
			pstm.setString(3, video.getSubtitle());
			pstm.setInt(4, video.getGroupId());
			pstm.setInt(5, video.getUserId());
			pstm.setInt(6, video.getId());
			result = pstm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int deleteVideoById(int id) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "delete from video where id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			result = pstm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
