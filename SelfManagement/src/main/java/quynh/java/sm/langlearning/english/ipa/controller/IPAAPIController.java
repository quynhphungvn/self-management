package quynh.java.sm.langlearning.english.ipa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import quynh.java.sm.langlearning.english.ipa.dto.IPASymbolDTO;
import quynh.java.sm.langlearning.english.ipa.service.IPASymbolService;

/**
 * Servlet implementation class IPAAPIController
 */
public class IPAAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPASymbolService ipaSymbolService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPAAPIController() {
        super();
        ipaSymbolService = new IPASymbolService();
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
		IPASymbolDTO symbol = ipaSymbolService.getIPASymbolDTOBySymbolId(userId, symbolId);
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
