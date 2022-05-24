package qyn.javaweb.ss.englearn.reading.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qyn.javaweb.ss.note.service.NoteService;

/**
 * Servlet implementation class EngReadingController
 */
public class EngReadingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoteService noteService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EngReadingController() {
        super();
        noteService = new NoteService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list-all-priority", noteService.getAllPriorityDTO());
		request.setAttribute("list-all-note-type", noteService.getAllNoteTypeDTO());
		request.setAttribute("list-all-note", noteService.getAllNoteDTO());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/englearn/reading/reading-support.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
