package qyn.javaweb.ss.englearn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import qyn.javaweb.ss.englearn.dao.VideoLearnDAO;
import qyn.javaweb.ss.englearn.model.VideoLearn;

/**
 * Servlet implementation class VideoLearnAPIController
 */
public class VideoLearnAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoLearnAPIController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String groupId = request.getParameter("groupid");
		List<VideoLearn> lVideoLearn = VideoLearnDAO.getAllVideoLearnByGroupId(Integer.parseInt(groupId));
		Gson gson = new Gson();
		response.getWriter().print(gson.toJson(lVideoLearn));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("update")) {
			VideoLearn video = new VideoLearn();
			video.setId(Integer.parseInt(request.getParameter("id")));
			video.setName(request.getParameter("name"));
			video.setTitle(request.getParameter("title"));
			video.setLink(request.getParameter("link"));
			video.setSubtitle(request.getParameter("subtitle"));
			VideoLearnDAO.updateVideoById(video);
		}
		if (action.equals("addvideo")) {
			VideoLearn video = new VideoLearn();
			video.setGroupId(Integer.parseInt(request.getParameter("groupId")));
			video.setName(request.getParameter("name"));
			video.setTitle(request.getParameter("title"));
			video.setLink(request.getParameter("link"));
			video.setSubtitle(request.getParameter("subtitle"));
			VideoLearnDAO.addVideo(video);
		}
	}
	
}
