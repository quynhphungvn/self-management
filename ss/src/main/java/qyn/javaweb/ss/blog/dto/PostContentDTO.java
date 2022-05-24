package qyn.javaweb.ss.blog.dto;

import java.util.List;

public class PostContentDTO {
	private int postId;
	private String postTitle;
	private String postContent;
	private List<TagDTO> listTag;
	
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
	public List<TagDTO> getListTag() {
		return listTag;
	}
	public void setListTag(List<TagDTO> listTag) {
		this.listTag = listTag;
	}
}
