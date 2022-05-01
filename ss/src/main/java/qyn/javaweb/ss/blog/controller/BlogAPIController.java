package qyn.javaweb.ss.blog.controller;

import java.io.IOException;
import java.util.regex.Matcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import qyn.javaweb.ss.blog.dto.PostClientDTO;
import qyn.javaweb.ss.blog.dto.PostContentDTO;
import qyn.javaweb.ss.blog.service.BlogService;
import qyn.javaweb.ss.util.Action;
import qyn.javaweb.ss.util.SSMessage;
import qyn.javaweb.ss.util.Status;

public class BlogAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BlogService blogService;   
    
    public BlogAPIController() {
        super();
        blogService = new BlogService();
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		SSMessage mes = null;
		String action = request.getParameter("action");
		if (action.equals(Action.GET_POST_CONTENT_BY_ID.getStatus())) {
			mes = actionGetPostContentById(request);
			response.getWriter().print(gson.toJson(mes));
		}
	}
	private SSMessage actionGetPostContentById(HttpServletRequest request) {
		SSMessage mes = new SSMessage();
		int postId = Integer.parseInt(request.getParameter("id"));
		PostContentDTO postContent = blogService.getPostContentDTOById(postId);
		if (postContent == null) 
			mes.setStatus(Status.GET_FAIL.getStatus());
		else {
			mes.setStatus(Status.GET_SUCCESS.getStatus());
			mes.setData(postContent);
		}
		return mes;
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		SSMessage mes = null;
		String action = request.getParameter("action");
		if (action.equals(Action.ADD_POST.getStatus())) {
			mes = actionAddPost(request);
			response.getWriter().print(gson.toJson(mes));
		} else if(action.equals(Action.UPDATE_POST.getStatus())) {
			mes = actionUpdatePost(request);
			response.getWriter().print(gson.toJson(mes));
		} else {
			
		}
	}
	private SSMessage actionAddPost(HttpServletRequest request) {
		SSMessage mes = new SSMessage();
		String tagIds = request.getParameter("tagId");		
		String title = request.getParameter("title");
		String rawContentClient = request.getParameter("postContent");
		String content = Matcher.quoteReplacement(rawContentClient.replaceAll("'", "''"));
		System.out.println(content);
		String[] tagIdsString = tagIds.split(",");
		int[] tagIdsInt = new int[tagIdsString.length];
		for (int i = 0; i < tagIdsString.length; i++) {
			tagIdsInt[i] = Integer.parseInt(tagIdsString[i]);
		}
		if (title == null || content == null || tagIds == null) {
			mes.setStatus(Status.PARAM_INVALID.getStatus());
			return mes;
		}
		PostClientDTO postClientDTO = new PostClientDTO(title, content, tagIdsInt);
		Status sts = blogService.addPost(postClientDTO);
		mes.setStatus(sts.getStatus());
		return mes;
	}
	private SSMessage actionUpdatePost(HttpServletRequest request) {
		SSMessage mes = new SSMessage();
		int id = Integer.parseInt(request.getParameter("id"));
		String tagIds = request.getParameter("tagId");		
		String title = request.getParameter("title");
		String rawContentClient = request.getParameter("postContent");
		String content = Matcher.quoteReplacement(rawContentClient.replaceAll("'", "''"));
		String[] tagIdsString = tagIds.split(",");
		int[] tagIdsInt = new int[tagIdsString.length];
		for (int i = 0; i < tagIdsString.length; i++) {
			tagIdsInt[i] = Integer.parseInt(tagIdsString[i]);
		}
		if (title == null || content == null || tagIds == null) {
			mes.setStatus(Status.PARAM_INVALID.getStatus());
			return mes;
		}
		PostClientDTO postClientDTO = new PostClientDTO(id, title, content, tagIdsInt);
		Status sts = blogService.updatePost(postClientDTO);
		mes.setStatus(sts.getStatus());
		return mes;
	}
}
