package quynh.java.sm.langlearning.english.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import quynh.java.sm.langlearning.english.model.WordLearning;
import quynh.java.sm.langlearning.english.service.impl.WordService;
import quynh.java.sm.support.app.message.ResponseMessage;
import quynh.java.sm.support.app.message.ClientAction;
import quynh.java.sm.support.app.message.SMError;
import quynh.java.sm.support.app.message.SMMessage;
import quynh.java.sm.support.app.message.SMStatus;
import quynh.java.sm.support.db.util.JDBCConnect;

/**
 * Servlet implementation class WordAPIController
 */
public class WordAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WordService wordService;
    private Gson gson;
    private ResponseMessage responseMessage;
    private Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordAPIController() {
        super();
        wordService = new WordService();
        gson = new Gson();
        responseMessage = new ResponseMessage();
        try {
			conn = JDBCConnect.getMySQLConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		SMMessage sm = null;
		int userId = 1;
		if (action.equals(ClientAction.GET_WORDKNOWNS.getStatus())) {
			List<WordLearning> wordKnowns = wordService.getWordsKnown(conn, userId);
			String s = " ";
			for (WordLearning word : wordKnowns) {
				//s = s + word.getContent() + " ";
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
		if (action.equals(ClientAction.ADD_WORD_TO_WORD_KNOWN.getStatus())) {
			String word = request.getParameter("word");
			int resultAdd = wordService.addWordToManage(conn, word, userId, true);
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
