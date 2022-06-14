package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quynh.java.sm.langlearning.english.model.VideoGroup;
import quynh.java.sm.langlearning.english.service.VideoGroupService;

/**
 * Servlet implementation class VideoWatchingController
 */
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	private VideoGroupService videoGroupService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoController() {
        super();
        videoGroupService = new VideoGroupService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VideoGroup> listVideoGroup = videoGroupService.getVideoGroupsByUserId(1);
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
