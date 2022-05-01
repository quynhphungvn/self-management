package qyn.javaweb.ss.blog.model;

import java.util.List;

public class Post {
	private int postId;
	private String postTitle;
	private String postContent;
	private List<Tag> listTag;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public List<Tag> getListTag() {
		return listTag;
	}
	public void setListTag(List<Tag> listTag) {
		this.listTag = listTag;
	}	
}
