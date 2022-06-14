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
 * Servlet implementation class EnglishManage
 */
public class EnglishManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoGroupService videoGroupService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnglishManageController() {
        super();
        videoGroupService = new VideoGroupService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest req = this.prepareDataForManagePage(request);
		this.forwardJsp(req, response);
	}
	private HttpServletRequest prepareDataForManagePage(HttpServletRequest request) {
		int userId = 1;
		List<VideoGroup> listVideoGroup = videoGroupService.getVideoGroupsByUserId(userId);
		request.setAttribute("listVideoGroup", listVideoGroup);
		return request;
	}
	private void forwardJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/langlearning/english/manage/manage.jsp");
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
