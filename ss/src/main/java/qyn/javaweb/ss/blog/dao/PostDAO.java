package qyn.javaweb.ss.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import qyn.javaweb.ss.blog.model.Post;
import qyn.javaweb.ss.blog.model.Tag;
import qyn.javaweb.ss.util.DBSupport;
import qyn.javaweb.ss.util.Status;

public class PostDAO {
	public static Status addPost(Post post) {
		Connection conn	= null;
		try {
			conn = DBSupport.getMySQLConnection();
			conn.setAutoCommit(false);
			Post postExistedWithSameTitle = PostDAO.getPostByTitle(post.getPostTitle(), false);
			if (postExistedWithSameTitle == null) {			
				Status resultInsertNewPost = PostDAO.insertToPostTable(DBSupport.getMySQLConnection(), post);
				if (resultInsertNewPost == Status.ADD_SUCCESS) {
					Post newPostInserted = PostDAO.getPostByTitle(post.getPostTitle(), false);
					if (newPostInserted != null) {
						Status status = PostDAO.insertPostTagRel(DBSupport.getMySQLConnection(), newPostInserted.getPostId(), post.getListTag());
						if (status == Status.ADD_FAIL) {
							conn.rollback();
							return Status.ADD_FAIL;
						}
						else {
							conn.commit();
							return Status.ADD_SUCCESS;
						}
					} else {
						conn.rollback();
						return Status.ADD_FAIL;
					}
				} else {
					conn.rollback();
					return Status.ADD_FAIL;
				}				
			}
			else {	
				conn.rollback();
				return Status.RESOURCE_DUPLICATE;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();			
			return Status.ADD_FAIL;
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Status updatePost(Post post) {
		Connection conn = null;
		String sql = "update post set title='" + post.getPostTitle() 
					+ "', content='" + post.getPostContent() + "' where id=" + post.getPostId() + ";";
		try {
			conn = DBSupport.getMySQLConnection();
			conn.setAutoCommit(false);
			Statement stm = conn.createStatement();
			int result = stm.executeUpdate(sql);
			if (result == 0)
				return Status.UPDATE_FAIL;
			else {
				Status sts = deletePostTagRelByPostId(DBSupport.getMySQLConnection(), post.getPostId());
				if (sts == Status.DELETE_FAIL)
				{
					conn.rollback();
					return Status.UPDATE_FAIL;
				}
				else {
					Status stsInsert = insertPostTagRel(DBSupport.getMySQLConnection(), post.getPostId(), post.getListTag());
					if (stsInsert == Status.ADD_FAIL)
					{
						conn.rollback();
						return Status.UPDATE_FAIL;
					}
					else {
						conn.commit();
						return Status.UPDATE_SUCCESS;
					}
				}
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
		return Status.UPDATE_FAIL;
	}
	public static Status insertToPostTable(Connection conn, Post post) {
		Statement stm;
		String sql = "insert into post (title, content) values ('"+ post.getPostTitle() 
		+ "','" + post.getPostContent() +"');";
		try {
			Post postExistedWithSameTitle = PostDAO.getPostByTitle(post.getPostTitle(), false);
			if (postExistedWithSameTitle == null) {
				stm = conn.createStatement();
				stm.executeUpdate(sql);
			}
			else {
				return Status.RESOURCE_DUPLICATE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Status.ADD_FAIL;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return Status.ADD_SUCCESS;
	}
	public static Status insertPostTagRel(Connection conn, int postId, List<Tag> tags) {
		for (int i = 0; i < tags.size(); i++) {
			Statement stm;
			try {
				stm = conn.createStatement();
				String sql = "insert into post_tag (post_id, tag_id) values ("+ postId + ", " + tags.get(i).getTagId() + ");";
				int result = stm.executeUpdate(sql);
				if (result != 1)
					return Status.ADD_FAIL;
			} catch (SQLException e) {				
				e.printStackTrace();
				return Status.ADD_FAIL;
			}
			
		}
		return Status.ADD_SUCCESS;
	}
	public static Status deletePostTagRelByPostId(Connection conn, int postId) {
		Statement stm;
		try {
			stm = conn.createStatement();
			String sql = "delete from post_tag where post_id=" + postId + ";";
			int result = stm.executeUpdate(sql);
			if (result == 0)
				return Status.DELETE_FAIL;
		} catch (SQLException e) {				
			e.printStackTrace();
			return Status.DELETE_FAIL;
		}
		return Status.DELETE_SUCCESS;
	}
	public static Post getPostByTitle(String title, boolean containTags) {
		Connection conn = null;
		Post post = null;
		String sql = "select * from post where title=\"" + title + "\";";

		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				post = new Post();
				post.setPostId(rs.getInt(1));
				post.setPostTitle(rs.getString(2));
				post.setPostContent(rs.getString(3));
				if (containTags) 
					post.setListTag(TagDAO.getTagsByPostId(post.getPostId(), !containTags));
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
		return post;
	}
	public static Post getPostById(int postId, boolean containTags) {
		Connection conn = null;
		String sql = "select * from post where id=" + postId + ";";
		Post post = null;
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				post = new Post();
				post.setPostId(rs.getInt(1));
				post.setPostTitle(rs.getString(2));
				post.setPostContent(rs.getString(3));
				if (containTags) {
					post.setListTag(TagDAO.getTagsByPostId(postId, !containTags));
				}
			}
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return post;
	}
	public static List<Post> getAllPost(boolean containTags) {
		Connection conn = null;
		List<Post> lPost = new ArrayList<Post>();
		String sql = "select * from post";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Post post = new Post();
				post.setPostId(rs.getInt(1));
				post.setPostTitle(rs.getString(2));
				post.setPostContent(rs.getString(3));
				if (containTags)
					post.setListTag(TagDAO.getTagsByPostId(post.getPostId(), !containTags));
				lPost.add(post);
			}
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lPost;
	}
	public static List<Post> getPostsByTagId(int tagId, boolean containTags) {
		Connection conn = null;
		List<Post> lPost = new ArrayList<Post>();
		String sql = "select post_id from post_tag where tag_id=" + tagId + ";";
		try {
			conn = DBSupport.getMySQLConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Post post = getPostById(rs.getInt(1), containTags);
				if (post != null)
					lPost.add(post);
			}
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lPost;
	}
}
