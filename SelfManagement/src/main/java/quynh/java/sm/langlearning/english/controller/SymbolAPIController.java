package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import quynh.java.sm.langlearning.english.dto.SymbolDTO;
import quynh.java.sm.langlearning.english.service.SymbolService;

/**
 * Servlet implementation class IPAAPIController
 */
public class SymbolAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SymbolService symbolService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SymbolAPIController() {
        super();
        symbolService = new SymbolService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String idString = request.getParameter("id");
		int symbolId = Integer.parseInt(idString);
		int userId = 1;
		SymbolDTO symbol = symbolService.getSymbolDTOBySymbolId(userId, symbolId);
		response.setCharacterEncoding("UTF8");
		response.getWriter().print(gson.toJson(symbol));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
