package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import quynh.java.sm.langlearning.english.model.Word;
import quynh.java.sm.langlearning.english.service.WordService;
import quynh.java.sm.support.app.message.ResponseMessage;
import quynh.java.sm.support.app.message.SMAction;
import quynh.java.sm.support.app.message.SMError;
import quynh.java.sm.support.app.message.SMMessage;
import quynh.java.sm.support.app.message.SMStatus;

/**
 * Servlet implementation class WordAPIController
 */
public class WordAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WordService wordService;
    private Gson gson;
    private ResponseMessage responseMessage;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordAPIController() {
        super();
        wordService = new WordService();
        gson = new Gson();
        responseMessage = new ResponseMessage();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		SMMessage sm = null;
		int userId = 1;
		if (action.equals(SMAction.GET_WORDKNOWNS.getStatus())) {
			List<Word> wordKnowns = wordService.getWordKnowns(userId);
			String s = " ";
			for (Word word : wordKnowns) {
				s = s + word.getWord() + " ";
			}
			sm = responseMessage.createResponseMessage(SMStatus.SUCCESS, s);
		}
		out.print(gson.toJson(sm));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		SMMessage sm = null;
		int userId = 1;
		if (action.equals(SMAction.ADD_WORD_TO_WORD_KNOWN.getStatus())) {
			String word = request.getParameter("word");
			int resultAdd = wordService.addWordToWordKnown(word, userId);
			if (resultAdd == 1)
				sm = responseMessage.createResponseMessage(SMStatus.SUCCESS, null);
			else if (resultAdd == -1)
				sm = responseMessage.createResponseMessage(SMStatus.FAIL, "Word invalid!");
			else
				sm = responseMessage.createResponseMessage(SMStatus.FAIL, SMError.UNKOWN_ERROR.getStatus());
		}
		out.print(gson.toJson(sm));
	}

}
