package quynh.java.sm.langlearning.english.ipa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quynh.java.sm.langlearning.english.ipa.model.IPASymbol;
import quynh.java.sm.langlearning.english.ipa.service.IPASymbolService;

/**
 * Servlet implementation class IPAController
 */
public class IPAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IPASymbolService ipaSymbolService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPAController() {
        super();
        ipaSymbolService = new IPASymbolService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<IPASymbol> lIPASymbol = ipaSymbolService.getAllIPASymbolByUser(1);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/langlearning/english/ipa/ipa.jsp");
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
