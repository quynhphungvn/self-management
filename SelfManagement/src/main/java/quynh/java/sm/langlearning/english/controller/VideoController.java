package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quynh.java.sm.langlearning.english.model.Group;
import quynh.java.sm.langlearning.english.service.GroupService;
import quynh.java.sm.langlearning.english.service.impl.VideoServiceImpl;

/**
 * Servlet implementation class VideoWatchingController
 */
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	private GroupService groupService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = 1;
		String type = "video";
		List<Group> listVideoGroup = groupService.getGroups(userId, type);
		request.setAttribute("listVideoGroup", listVideoGroup);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/langlearning/english/video/video.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
