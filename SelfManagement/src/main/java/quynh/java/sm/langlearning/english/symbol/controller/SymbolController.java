package quynh.java.sm.langlearning.english.symbol.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quynh.java.sm.langlearning.english.symbol.model.Symbol;
import quynh.java.sm.langlearning.english.symbol.service.SymbolService;

/**
 * Servlet implementation class IPAController
 */
public class SymbolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SymbolService symbolService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SymbolController() {
        super();
        symbolService = new SymbolService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Symbol> lIPASymbol = symbolService.getAllSymbolByUser(1);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/langlearning/english/symbol/symbol.jsp");
		request.setAttribute("list-ipa-symbol", lIPASymbol);
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
