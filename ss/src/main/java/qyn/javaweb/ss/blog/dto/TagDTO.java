package qyn.javaweb.ss.blog.dto;

import java.util.List;

public class TagDTO {
	private int tagId;
	private String tagName;
	private List<PostInfoDTO> lPostInfoDTO;
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public List<PostInfoDTO> getlPostInfoDTO() {
		return lPostInfoDTO;
	}
	public void setlPostInfoDTO(List<PostInfoDTO> lPostInfoDTO) {
		this.lPostInfoDTO = lPostInfoDTO;
	}
}
