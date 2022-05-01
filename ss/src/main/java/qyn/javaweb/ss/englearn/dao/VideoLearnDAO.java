package qyn.javaweb.ss.englearn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.englearn.model.VideoLearn;
import qyn.javaweb.ss.util.DBSupport;

public class VideoLearnDAO {
	public static List<VideoLearn> getAllVideoLearnByGroupId(int id) {
		List<VideoLearn> lVideoLearn = new ArrayList<VideoLearn>();		
		Connection conn = null;
		String sql = "select * from video_learn where group_id=" + id + ";";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				VideoLearn v = new VideoLearn();
				v.setId(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setTitle(rs.getString(3));
				v.setLink(rs.getString(4));
				v.setSubtitle(rs.getString(5));
				v.setGroupId(rs.getInt(6));
				lVideoLearn.add(v);
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
		return lVideoLearn;
	}
	public static void updateVideoById (VideoLearn video) {
		Connection conn = null;
		String vName = video.getName().replaceAll("'", "''");
		String vTitle = video.getTitle().replaceAll("'", "''");
		String vLink = video.getLink().replaceAll("'", "''");
		String vSubtitle = video.getSubtitle().replaceAll("'", "''");
		String sql = "update video_learn set name='" + vName + "', title='" + vTitle +"', link='" 
						+ vLink + "', subtitle='"+ vSubtitle + "' where id=" + video.getId() + ";";
		Statement stm;
		try {
			conn = DBSupport.getMySQLConnection();
			stm = conn.createStatement();
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
	public static void addVideo(VideoLearn video) {
		Connection conn = null;
		String vName = video.getName().replaceAll("'", "''");
		String vTitle = video.getTitle().replaceAll("'", "''");
		String vLink = video.getLink().replaceAll("'", "''");
		String vSubtitle = video.getSubtitle().replaceAll("'", "''");
		String sql = "insert into video_learn(name, title, link, subtitle, group_id) values('" + vName + "','" + vTitle +"','" 
						+ vLink + "','"+ vSubtitle + "'," + video.getGroupId() + ");";
		Statement stm;
		try {
			conn = DBSupport.getMySQLConnection();
			stm = conn.createStatement();
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
}
