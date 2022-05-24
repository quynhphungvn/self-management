package qyn.javaweb.ss.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qyn.javaweb.ss.blog.service.BlogService;
import qyn.javaweb.ss.note.service.NoteService;

/**
 * Servlet implementation class BlogController
 */
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BlogService blogService;
    private NoteService noteService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogController() {
        super();
        blogService = new BlogService();
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
		request.setAttribute("list-all-tag-dto", blogService.getAllTagDTO(true));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/blog/blog.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
