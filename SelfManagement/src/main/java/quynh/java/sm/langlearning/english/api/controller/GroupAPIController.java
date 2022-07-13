package quynh.java.sm.langlearning.english.api.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quynh.java.sm.langlearning.english.dto.GroupClientDto;
import quynh.java.sm.langlearning.english.model.Group;
import quynh.java.sm.langlearning.english.service.GroupService;
import quynh.java.sm.support.app.message.ClientAction;
import quynh.java.sm.support.app.message.ResponseCode;
import quynh.java.sm.support.app.message.ResponseCreator;

/**
 * Servlet implementation class VideoGroup
 */
public class GroupAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GroupService groupService;
    private ResponseCreator responseCreator;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupAPIController() {
        super();
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
		
		if (action.equals(ClientAction.ADD_VIDEO_GROUP.getStatus())) {
			out.print(addGroup(request));
		}
		else if (action.equals(ClientAction.DELETE_VIDEO_GROUP.getStatus())) {	
			out.print(deleteGroup(request));
		}
	}
	
	private String addGroup(HttpServletRequest request) {
		int userId = 1;
		String groupType = "video";
		String groupName = request.getParameter("groupName");
		
		Group groupAdded = groupService.addGroup(groupName, groupType, userId);
		if (groupAdded != null) {
			return responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, groupAdded);
		}
		else {
			return responseCreator.createJsonResponseMessage(ResponseCode.UNKOWN_ERROR, null);
		}
	}
	private String deleteGroup(HttpServletRequest request) {
		int userId = 1;
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		
		Group groupDeleted = groupService.deleteGroup(groupId, userId);
		if (groupDeleted != null) {
			return responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, groupDeleted);
		}
		else {
			return responseCreator.createJsonResponseMessage(ResponseCode.UNKOWN_ERROR, null);
		}
	}
}
