package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import quynh.java.sm.langlearning.english.model.VideoGroup;
import quynh.java.sm.langlearning.english.service.VideoGroupService;
import quynh.java.sm.support.app.message.SMAction;
import quynh.java.sm.support.app.message.SMError;
import quynh.java.sm.support.app.message.SMMessage;
import quynh.java.sm.support.app.message.SMStatus;

/**
 * Servlet implementation class VideoGroup
 */
public class VideoGroupAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoGroupService videoGroupService;
    private Gson gson;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoGroupAPIController() {
        super();
        videoGroupService = new VideoGroupService();
        gson = new Gson();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		SMMessage smResult = null;
		if (action.equals(SMAction.ADD_VIDEO_GROUP.getStatus())) {
			smResult = addVideoGroup(request);
		}
		else if (action.equals(SMAction.DELETE_VIDEO_GROUP.getStatus())) {	
			smResult = deleteVideoGroup(request);
		}
		out.print(gson.toJson(smResult));
	}
	
	private SMMessage addVideoGroup(HttpServletRequest request) {
		int userId = 1;
		String groupName = request.getParameter("groupName");
		int resultAdd = videoGroupService.addVideoGroup(new VideoGroup(0, userId, groupName));
		SMMessage mes = new SMMessage();
		if (resultAdd == 1) {
			mes.setStatus(SMStatus.SUCCESS.getStatus());
		}
		else {
			mes.setStatus(SMStatus.FAIL.getStatus());
			mes.setData(SMError.UNKOWN_ERROR.getStatus());
		}
		return mes;
	}
	private SMMessage deleteVideoGroup(HttpServletRequest request) {
		int userId = 1;
		String groupName = request.getParameter("groupName");
		int resultDel = videoGroupService.deleteVideoGroup(new VideoGroup(0, userId, groupName));
		SMMessage mes = new SMMessage();
		if (resultDel == 1) {
			mes.setStatus(SMStatus.SUCCESS.getStatus());
		}
		else {
			mes.setStatus(SMStatus.FAIL.getStatus());
			mes.setData(SMError.UNKOWN_ERROR.getStatus());
		}
		return mes;
	}
}
