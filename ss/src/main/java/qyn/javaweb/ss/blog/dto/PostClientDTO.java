package qyn.javaweb.ss.blog.dto;

public class PostClientDTO {
	private int postId;
	private String postTitle;
	private String postContent;
	private int[] postTags;
	public PostClientDTO(String postTitle, String postContent, int[] postTags) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postTags = postTags;
	}
	public PostClientDTO(int postId, String postTitle, String postContent, int[] postTags) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postTags = postTags;
	}
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
	public int[] getPostTags() {
		return postTags;
	}
	public void setPostTags(int[] postTags) {
		this.postTags = postTags;
	}
	
	
}
