package qyn.javaweb.ss.englearn.word.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import qyn.javaweb.ss.englearn.word.dto.WordKnownDTO;
import qyn.javaweb.ss.englearn.word.service.WordKnownService;
import qyn.javaweb.ss.englearn.word.service.WordService;
import qyn.javaweb.ss.util.Action;
import qyn.javaweb.ss.util.SSMessage;
import qyn.javaweb.ss.util.Status;

/**
 * Servlet implementation class WordKnownAPIController
 */
public class WordKnownAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    WordService wordService;
    WordKnownService wordKnownService;
    Gson gson = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordKnownAPIController() {
        super();
        wordService = new WordService();
        wordKnownService = new WordKnownService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		SSMessage mes = new SSMessage();
		if (action.equals(Action.GET_ALL_WORD_KNOWN.getStatus())) {
			List<WordKnownDTO> lWordKnownDTO = wordService.getAllWordKnown();
			if (lWordKnownDTO.size() == 0) {
				mes.setStatus(Status.GET_FAIL.getStatus());
			} else {
				mes.setStatus(Status.GET_SUCCESS.getStatus());
				mes.setData(lWordKnownDTO);
			}
			response.getWriter().print(gson.toJson(mes));
		}
		if (action.equals(Action.ADD_WORD_TO_WORD_KNOWN.getStatus())) {
			String wordKnown = request.getParameter("word");
			WordKnownDTO wordKnownDTO = new WordKnownDTO(wordKnown);
			Status sts = wordKnownService.addWordKnown(wordKnownDTO);
			mes.setStatus(sts.getStatus());
			response.getWriter().print(gson.toJson(mes));
		}
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
