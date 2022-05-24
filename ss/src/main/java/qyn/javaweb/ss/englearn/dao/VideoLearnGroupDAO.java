package qyn.javaweb.ss.englearn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.englearn.model.VideoLearnGroup;
import qyn.javaweb.ss.util.DBSupport;

public class VideoLearnGroupDAO {
	public static List<VideoLearnGroup> getAllVideoLearnGroup() {
		List<VideoLearnGroup> lVideoLearnGroup = new ArrayList<VideoLearnGroup>();
		Connection conn = null;
		String sql = "select * from video_learn_group;";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				VideoLearnGroup group = new VideoLearnGroup();
				group.setId(rs.getInt(1));
				group.setName(rs.getString(2));
				lVideoLearnGroup.add(group);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
		return lVideoLearnGroup;
	}
	public static void addVideoLearnGroup(String groupName) {
		Connection conn = null;
		String sql = "insert into video_learn_group (name) values('" + groupName + "')";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm  = conn.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
	public static VideoLearnGroup getVideoLearnGroupByGroupName(String groupName) {
		Connection conn = null;
		String sql = "select * from video_learn_group where name='" + groupName + "'";
		VideoLearnGroup vGroup = null;
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm  = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next())
			{
				vGroup = new VideoLearnGroup();
				vGroup.setId(rs.getInt(1));
				vGroup.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return vGroup;
	}
}
