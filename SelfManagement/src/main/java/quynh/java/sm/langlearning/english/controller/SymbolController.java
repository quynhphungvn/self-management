package quynh.java.sm.langlearning.english.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quynh.java.sm.langlearning.english.model.Symbol;
import quynh.java.sm.langlearning.english.model.SymbolLearning;
import quynh.java.sm.langlearning.english.service.SymbolService;
import quynh.java.sm.langlearning.english.service.impl.SymbolServiceImpl;

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
        symbolService = new SymbolServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showSymbolPage(request,response);
	}
	private void showSymbolPage(HttpServletRequest request, HttpServletResponse response) {
		List<Symbol> symbols = symbolService.getSymbols();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/langlearning/english/symbol/symbol.jsp");
		request.setAttribute("symbols", symbols);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
