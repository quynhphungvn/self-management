package qyn.javaweb.ss.englearn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import qyn.javaweb.ss.englearn.dao.WordDAO;
import qyn.javaweb.ss.englearn.word.model.Word;

/**
 * Servlet implementation class WordAPIController
 */
public class WordAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordAPIController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Gson gson = new Gson();
		if (action.equals("get-knownwords")) {
			List<Word> listWord = WordDAO.getAllKnownWord();
			response.getWriter().print(gson.toJson(listWord));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Gson gson = new Gson();
		if (action.equals("add-knownword")) {
			String word = request.getParameter("word");
			System.out.println(word);
			WordDAO.addToWordKnown(word);
		}
	}

}
