package quynh.java.sm.langlearning.english.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import quynh.java.sm.langlearning.english.model.Video;
import quynh.java.sm.langlearning.english.service.impl.VideoService;
import quynh.java.sm.support.app.message.ResponseMessage;
import quynh.java.sm.support.app.message.ClientAction;
import quynh.java.sm.support.app.message.ResponseCode;
import quynh.java.sm.support.app.message.ResponseCreator;
import quynh.java.sm.support.app.message.SMMessage;
import quynh.java.sm.support.app.message.SMStatus;
import quynh.java.sm.support.db.util.JDBCConnect;

/**
 * Servlet implementation class VideoAPIController
 */
public class VideoAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoService videoService;  
    private ResponseMessage responseMessage;
    private ResponseCreator responseCreator;
    private Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoAPIController() {
        super();
        videoService = new VideoService();
        responseMessage = new ResponseMessage();
        try {
			conn = JDBCConnect.getMySQLConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action.equals(ClientAction.GET_VIDEOS_BY_GROUP_ID.getStatus())){
			int groupId = request.getParameter("groupId");
			List<Video> lVideo = this.getVideosByGroupId(groupId);
			out.print(responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, lVideo));
		
		} else if (action.equals(ClientAction.GET_VIDEO_BY_ID.getStatus())) {
			int videoId = request.getParameter("videoId");
			Video v = this.getVideoById(videoId);
			out.print(responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, v));
		}
//		if (action.equals(ClientAction.GET_VIDEOS_BY_GROUP_ID.getStatus())) {
//			int groupId = Integer.parseInt(request.getParameter("groupId"));
//			int userId = 1;
//			List<Video> listVideo = videoService.getVideosByGroupId(groupId, userId);		
//			smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, listVideo);
//		}
//		if (action.equals(ClientAction.GET_VIDEO_BY_ID.getStatus())) {
//			int videoId = Integer.parseInt(request.getParameter("videoId"));
//			int userId = 1;
//			Video video = videoService.getVideoById(videoId, userId);
//			if (video != null)
//				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, video);
//			else 
//				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
//		}
//		out.print(gson.toJson(smm));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action.equals(ClientAction.ADD_VIDEO.getStatus())) {
			VideoClientDto vDto = new VideoClientDto();
			int result = this.addVideo(vDto);
			if (result == 1) {
				out.print(responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, null));
			}
		} else if (action.equals(ClientAction.UPDATE_VIDEO.getStatus())) {
			VideoClientDto vDto = new VideoClientDto();
			int result = this.updateVideo(vDto);
			if (result == 1) {
				out.print(responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, null));
			}
		} else if (action.equals(ClientAction.DELETE_VIDEO.getStatus())) {
			int videoId = 0;
			int result = this.deleteVideo(videoId);
			if (result == 1) {
				out.print(responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, null));
			}
		} else if (action.equals(ClientAction.INCREASE_VIEW_COUNT.getStatus())) {
			int videoId = 0;
			int result = this.increaseViewCount(videoId);
			if (result == 1) {
				out.print(responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, null));
			}
		}
//		if (action.equals(ClientAction.ADD_VIDEO.getStatus())) {
//			String title = request.getParameter("title");
//			String url = request.getParameter("url");
//			int groupId = Integer.parseInt(request.getParameter("groupId"));
//			String subtitle = request.getParameter("subtitle");
//			int userId = 1;
//			Video video = new Video(0, title, url, subtitle, groupId, userId, 0);
//			Video videoAdded = videoService.addVideo(conn, video);
//			if (videoAdded != null)
//				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, videoAdded);
//			else 
//				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
//		}
//		else if (action.equals(ClientAction.UPDATE_VIDEO.getStatus())) {
//			int id = Integer.parseInt(request.getParameter("id"));
//			String title = request.getParameter("title");
//			String url = request.getParameter("url");	
//			String subtitle = request.getParameter("subtitle");
//			int groupId = Integer.parseInt(request.getParameter("groupId"));
//			int userId = 1;
//			Video video = new Video (id, title, url, subtitle, groupId, userId, 0);
//			int result = videoService.updateVideo(video);
//			if (result == 1)
//				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, null);
//			else 
//				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
//		}
//		else if (action.equals(ClientAction.DELETE_VIDEO.getStatus())) {
//			int id = Integer.parseInt(request.getParameter("id"));
//			int result = videoService.deleteVideo(id);
//			if (result == 1)
//				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, id);
//			else 
//				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
//		}
//		else if (action.equals(ClientAction.UPDATE_VIDEO_VIEW_COUNT.getStatus())) {
//			int videoId = Integer.parseInt(request.getParameter("videoId"));
//			int userId = 1;
//			int newViewCount = videoService.updateVideoViewCount(videoId, userId);
//			if (newViewCount != 0) 
//				smm = responseMessage.createResponseMessage(SMStatus.SUCCESS, newViewCount);
//			else 
//				smm = responseMessage.createResponseMessage(SMStatus.FAIL, null);
//		}
//		else {}
//		out.print(gson.toJson(smm));
	}
 }
