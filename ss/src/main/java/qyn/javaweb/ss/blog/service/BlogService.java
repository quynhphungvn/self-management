package qyn.javaweb.ss.blog.service;

import java.util.List;

import qyn.javaweb.ss.blog.dao.PostDAO;
import qyn.javaweb.ss.blog.dao.TagDAO;
import qyn.javaweb.ss.blog.dto.PostClientDTO;
import qyn.javaweb.ss.blog.dto.PostContentDTO;
import qyn.javaweb.ss.blog.dto.TagDTO;
import qyn.javaweb.ss.blog.mapper.BlogMapper;
import qyn.javaweb.ss.util.Status;

public class BlogService {
	BlogMapper blogMapper = new BlogMapper();
	
	public List<TagDTO> getAllTagDTO(boolean containListPostInfo) {
		return blogMapper.mapListTagToListTagDTO(TagDAO.getAllTag(containListPostInfo));
	}
	public PostContentDTO getPostContentDTOById(int postId) {
		return blogMapper.mapPostToPostContentDTO(PostDAO.getPostById(postId, true));
	}
	public Status addPost(PostClientDTO postClientDTO) {
		return PostDAO.addPost(blogMapper.mapPostClientDTOToPost(postClientDTO));
	}
	public Status updatePost(PostClientDTO postClientDTO) {
		return PostDAO.updatePost(blogMapper.mapPostClientDTOToPost(postClientDTO));
	}
}
