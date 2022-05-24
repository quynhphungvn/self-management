package qyn.javaweb.ss.englearn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qyn.javaweb.ss.englearn.dao.VideoLearnGroupDAO;

/**
 * Servlet implementation class VideoLearnGroupAPIController
 */
public class VideoLearnGroupAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoLearnGroupAPIController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("Add group");
		String action = request.getParameter("action");
		if (action.equals("addgroup")) {
			String groupName = request.getParameter("groupName");
			if (VideoLearnGroupDAO.getVideoLearnGroupByGroupName(groupName) != null)
				VideoLearnGroupDAO.addVideoLearnGroup(groupName);
		}
	}

}
