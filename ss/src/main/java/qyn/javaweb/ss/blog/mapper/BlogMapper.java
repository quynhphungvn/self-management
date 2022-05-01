package qyn.javaweb.ss.blog.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import qyn.javaweb.ss.blog.dto.PostClientDTO;
import qyn.javaweb.ss.blog.dto.PostContentDTO;
import qyn.javaweb.ss.blog.dto.PostInfoDTO;
import qyn.javaweb.ss.blog.dto.TagDTO;
import qyn.javaweb.ss.blog.model.Post;
import qyn.javaweb.ss.blog.model.Tag;

public class BlogMapper {
	ModelMapper modelMapper = new ModelMapper();
	
	public List<TagDTO> mapListTagToListTagDTO(List<Tag> lTag) {
		List<TagDTO> lTagDTO = new ArrayList<TagDTO>();
		lTag.forEach(tag -> lTagDTO.add(mapTagToTagDTO(tag)));
		return lTagDTO;
	}
	public TagDTO mapTagToTagDTO(Tag tag) {
		TagDTO tagDTO = new TagDTO();
		tagDTO.setTagId(tag.getTagId());
		tagDTO.setTagName(tag.getTagName());
		if (tag.getListPost() != null) {
			tagDTO.setlPostInfoDTO(this.mapListPostToListPostInfoDTO(tag.getListPost()));
		}
		return tagDTO;
	}
	public List<PostInfoDTO> mapListPostToListPostInfoDTO(List<Post> lPost) {
		List<PostInfoDTO> lPostInfoDTO = new ArrayList<PostInfoDTO>();
		lPost.forEach(post -> lPostInfoDTO.add(mapPostToPostInfoDTO(post)));
		return lPostInfoDTO;
	}
	public PostInfoDTO mapPostToPostInfoDTO(Post post) {
		modelMapper.typeMap(Post.class, PostInfoDTO.class).addMappings(mapper -> {
			mapper.map(src -> src.getPostId(), PostInfoDTO::setPostId);
			mapper.map(src -> src.getPostTitle(), PostInfoDTO::setPostTitle);
		});
		return modelMapper.map(post, PostInfoDTO.class);
	}
	public PostContentDTO mapPostToPostContentDTO(Post post) {
		modelMapper.typeMap(Post.class, PostContentDTO.class).addMappings(mapper -> {
			mapper.map(src -> src.getPostId(), PostContentDTO::setPostId);
			mapper.map(src -> src.getPostTitle(), PostContentDTO::setPostTitle);
			mapper.map(src -> src.getPostContent(), PostContentDTO::setPostContent);
		});
		PostContentDTO postContent = modelMapper.map(post, PostContentDTO.class);
		postContent.setListTag(mapListTagToListTagDTO(post.getListTag()));
		return postContent;
	}
	public Post mapPostClientDTOToPost(PostClientDTO postClientDTO) {
		modelMapper.typeMap(PostClientDTO.class, Post.class).addMappings(mapper -> {
			mapper.map(src -> src.getPostId(), Post::setPostId);
			mapper.map(src -> src.getPostTitle(), Post::setPostTitle);
			mapper.map(src -> src.getPostContent(), Post::setPostContent);
		});
		Post post  = modelMapper.map(postClientDTO, Post.class);
		List<Tag> tags = new ArrayList<Tag>();
		int[] arrTag = postClientDTO.getPostTags();
		for (int i = 0; i < arrTag.length; i++)
		{
			Tag tag = new Tag();
			tag.setTagId(arrTag[i]);
			tags.add(tag);
		}
		post.setListTag(tags);	
		return post;
	}
}
