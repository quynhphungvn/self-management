package quynh.java.sm.langlearning.english.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import quynh.java.sm.langlearning.english.video.model.VideoGroup;
import quynh.java.sm.support.db.util.JDBCConnect;

public class VideoGroupDAO {
	public List<VideoGroup> getAllVideoGroupByUserId(int userId) {
		Connection conn = null;
		List<VideoGroup> lGroup = new ArrayList<VideoGroup>();
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "select * from video_group;";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				VideoGroup g = new VideoGroup();
				g.setId(rs.getInt(1));
				g.setUserId(rs.getInt(2));
				g.setName(rs.getString(3));
				lGroup.add(g);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lGroup;
	}
	public void addVideoGroup(VideoGroup vGroup) {
		Connection conn = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "insert into video_group(user_id, name) values(?,?);";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, vGroup.getUserId());
			pstm.setString(2, vGroup.getName());
			pstm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delVideoGroupById(int id) {
		Connection conn = null;
		try {
			conn = JDBCConnect.getMySQLConnection();
			String sql = "delete from video_group where id=?;";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
																		