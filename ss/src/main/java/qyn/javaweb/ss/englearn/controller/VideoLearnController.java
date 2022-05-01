package qyn.javaweb.ss.englearn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qyn.javaweb.ss.englearn.dao.VideoLearnGroupDAO;
import qyn.javaweb.ss.englearn.ipa.dao.IPASymbolDAO;
import qyn.javaweb.ss.englearn.ipa.model.IPASymbol;
import qyn.javaweb.ss.englearn.model.VideoLearnGroup;
import qyn.javaweb.ss.note.service.NoteService;

/**
 * Servlet implementation class VideoLearningController
 */
public class VideoLearnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    NoteService noteService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoLearnController() {
        super();
        noteService = new NoteService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<IPASymbol> listIPASymbol = IPASymbolDAO.getAllIPASymbol();
		request.setAttribute("list-ipa-symbol", listIPASymbol);
		List<VideoLearnGroup> listVideoLearnGroup = VideoLearnGroupDAO.getAllVideoLearnGroup();
		request.setAttribute("video-groups", listVideoLearnGroup);
		request.setAttribute("list-all-priority", noteService.getAllPriorityDTO());
		request.setAttribute("list-all-note-type", noteService.getAllNoteTypeDTO());
		request.setAttribute("list-all-note", noteService.getAllNoteDTO());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/englearn/video-learn/videolearn.jsp");
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
