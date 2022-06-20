package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import quynh.java.sm.langlearning.english.model.Video;
import quynh.java.sm.langlearning.english.service.VideoService;
import quynh.java.sm.support.app.message.ResponseMessage;
import quynh.java.sm.support.app.message.SMAction;
import quynh.java.sm.support.app.message.SMMessage;
import quynh.java.sm.support.app.message.SMStatus;

/**
 * Servlet implementation class VideoAPIController
 */
public class VideoAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoService videoService;  
    private ResponseMessage responseMessage;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoAPIController() {
        super();
        videoService = new VideoService();
        responseMessage = new ResponseMessage();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		SMMessage smm = null;
		if (action.equals(SMAction.GET_VIDEOS_BY_GROUP_ID.getStatus())) {
			int groupId = Integer.parseInt(request.getParameter("groupId"));
			int userId = 1;
			List<Video> listVideo = videoService.getVideosByGroupId(groupId, userId);		
			smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, listVideo);
		}
		if (action.equals(SMAction.GET_VIDEO_BY_ID.getStatus())) {
			int videoId = Integer.parseInt(request.getParameter("videoId"));
			int userId = 1;
			Video video = videoService.getVideoById(videoId, userId);
			if (video != null)
				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, video);
			else 
				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
		}
		out.print(gson.toJson(smm));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		SMMessage smm = null;
		if (action.equals(SMAction.ADD_VIDEO.getStatus())) {
			String title = request.getParameter("title");
			String url = request.getParameter("url");
			int groupId = Integer.parseInt(request.getParameter("groupId"));
			String subtitle = request.getParameter("subtitle");
			int userId = 1;
			Video video = new Video(0, title, url, subtitle, groupId, userId, 0);
			Video videoAdded = videoService.addVideo(video);
			if (videoAdded != null)
				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, videoAdded);
			else 
				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
		}
		else if (action.equals(SMAction.UPDATE_VIDEO.getStatus())) {
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String url = request.getParameter("url");	
			String subtitle = request.getParameter("subtitle");
			int groupId = Integer.parseInt(request.getParameter("groupId"));
			int userId = 1;
			Video video = new Video (id, title, url, subtitle, groupId, userId, 0);
			int result = videoService.updateVideo(video);
			if (result == 1)
				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, null);
			else 
				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
		}
		else if (action.equals(SMAction.DELETE_VIDEO.getStatus())) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = videoService.deleteVideo(id);
			if (result == 1)
				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, id);
			else 
				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
		}
		else if (action.equals(SMAction.UPDATE_VIDEO_VIEW_COUNT.getStatus())) {
			int videoId = Integer.parseInt(request.getParameter("videoId"));
			int userId = 1;
			int newViewCount = videoService.updateVideoViewCount(videoId, userId);
			if (newViewCount != 0) 
				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, newViewCount);
			else 
				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
		}
		else {}
		out.print(gson.toJson(smm));
	}
 }
