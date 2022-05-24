package qyn.javaweb.ss.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.blog.model.Tag;
import qyn.javaweb.ss.util.DBSupport;

public class TagDAO {
	public static List<Tag> getAllTag(boolean containsPost) {
		Connection conn = null;
		List<Tag> lTag = new ArrayList<Tag>();
		String sql = "select * from tag;";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Tag tag = new Tag();
				tag.setTagId(rs.getInt(1));
				tag.setTagName(rs.getString(2));
				if (containsPost) 
					tag.setListPost(PostDAO.getPostsByTagId(tag.getTagId(), !containsPost));
				lTag.add(tag);
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
		return lTag;
	}
	public static List<Tag> getTagsByPostId(int postId, boolean containPosts) {
		Connection conn = null;
		List<Tag> lTag = new ArrayList<Tag>();
		String sql = "select tag_id from post_tag where post_id=" + postId + ";";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Tag tag = TagDAO.getTagById(rs.getInt(1), containPosts);
				if (tag != null)
					lTag.add(tag);
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
		return lTag;
	}
	public static Tag getTagById(int tagId, boolean containPosts) {
		Connection conn = null;
		Tag tag = null;
		String sql = "select * from tag where id="+ tagId + ";";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				tag = new Tag();
				tag.setTagId(rs.getInt(1));
				tag.setTagName(rs.getString(2));
				if (containPosts)
					tag.setListPost(PostDAO.getPostsByTagId(tagId, !containPosts));
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
		return tag;
	}
}
