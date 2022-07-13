package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quynh.java.sm.langlearning.english.dto.GroupDto;
import quynh.java.sm.langlearning.english.model.Group;
import quynh.java.sm.langlearning.english.service.GroupService;
import quynh.java.sm.langlearning.english.service.impl.GroupServiceImpl;

/**
 * Servlet implementation class EnglishManage
 */
public class EnglishManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GroupService groupService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnglishManageController() {
        super();
        groupService = new GroupServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = 1;
		String type="video";
		List<GroupDto> groups = groupService.getAll(userId, type);
		request.setAttribute("groups", groups);
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
