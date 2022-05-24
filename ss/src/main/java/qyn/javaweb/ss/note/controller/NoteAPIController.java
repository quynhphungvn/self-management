package qyn.javaweb.ss.note.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import qyn.javaweb.ss.note.dto.NoteClientDTO;
import qyn.javaweb.ss.note.service.NoteService;
import qyn.javaweb.ss.util.Action;
import qyn.javaweb.ss.util.SSMessage;
import qyn.javaweb.ss.util.Status;

/**
 * Servlet implementation class NoteAPIController
 */
public class NoteAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoteService noteService;
    Gson gson = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteAPIController() {
        super();
        noteService = new NoteService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals(Action.ADD_NOTE.getStatus())) {
			SSMessage mes = actionAddNote(request);
			response.getWriter().print(gson.toJson(mes));
		}
		if (action.equals(Action.DELETE_NOTE.getStatus())) {
			SSMessage mes = actionDeleteNote(request);
			response.getWriter().print(gson.toJson(mes));
		}
	}
	private SSMessage actionAddNote(HttpServletRequest request) {
		SSMessage mes = null;
		String priorityId = request.getParameter("priorityId");
		String noteTypeId = request.getParameter("noteTypeId");
		String noteContent = request.getParameter("noteContent");
		String noteComment = request.getParameter("noteComment");
		LocalDateTime currentTime = LocalDateTime.now();
		Date timeAdd = Timestamp.valueOf(currentTime);
		if (noteContent == null || noteContent == "" || noteContent.length() == 0) {
			mes = new SSMessage();	
			mes.setStatus(Status.PARAM_INVALID.getStatus());
			return mes;
		}	
		NoteClientDTO noteClientDTO = new NoteClientDTO(noteContent, noteComment, timeAdd, Integer.parseInt(priorityId), Integer.parseInt(noteTypeId));
		Status stsAdd = noteService.addNote(noteClientDTO);
		mes = new SSMessage();
		mes.setStatus(stsAdd.getStatus());
		return mes;
	}
	private SSMessage actionDeleteNote(HttpServletRequest request) {
		SSMessage mes = new SSMessage();
		String noteId = request.getParameter("id");
		Status sts = noteService.deleteNoteById(Integer.parseInt(noteId));
		mes.setStatus(sts.getStatus());
		return mes;
	}
}
