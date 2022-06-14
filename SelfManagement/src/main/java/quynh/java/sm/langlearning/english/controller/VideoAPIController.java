package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import quynh.java.sm.langlearning.english.model.Video;
import quynh.java.sm.langlearning.english.service.VideoService;
import quynh.java.sm.support.app.message.SMAction;
import quynh.java.sm.support.app.message.SMMessage;

/**
 * Servlet implementation class VideoAPIController
 */
public class VideoAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoService videoService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoAPIController() {
        super();
        videoService = new VideoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		SMMessage smm = null;
		if (action.equals(SMAction.GETS.getStatus())) {
			smm = getVideos(request);
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
		if (action.equals(SMAction.ADD.getStatus())) {
			smm = addVideo(request);
		}
		out.print(gson.toJson(smm));
	}
	private SMMessage addVideo(HttpServletRequest request) {
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		String subtitle = request.getParameter("subtitle");
		int userId = 1;
		Video v = new Video(0, title, url, subtitle, groupId, userId, 0);
		return videoService.addVideo(v);
	}
	private SMMessage getVideos(HttpServletRequest request) {
		SMMessage smm = null;
		String groupId = request.getParameter("groupId");
		int userId = 1;
		if (groupId != null) {
			smm = videoService.getVideosByGroupId(Integer.parseInt(groupId), userId);
		}
		return smm;
	}
 }
