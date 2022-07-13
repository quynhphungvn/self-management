package quynh.java.sm.langlearning.english.api.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import quynh.java.sm.langlearning.english.dto.SymbolDto;
import quynh.java.sm.langlearning.english.model.SymbolLearning;
import quynh.java.sm.langlearning.english.service.SymbolService;
import quynh.java.sm.langlearning.english.service.impl.SymbolServiceImpl;
import quynh.java.sm.support.app.message.ResponseCode;
import quynh.java.sm.support.app.message.ResponseCreator;

/**
 * Servlet implementation class IPAAPIController
 */
public class SymbolAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResponseCreator responseCreator;
	private SymbolService symbolService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SymbolAPIController() {
        super();
        symbolService = new SymbolServiceImpl();
        responseCreator = new ResponseCreator();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int symbolId = Integer.parseInt(request.getParameter("id"));
		int userId = 1;
		SymbolDto symbolDto = symbolService.getSymbol(symbolId, userId);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(responseCreator.createJsonResponseMessage(ResponseCode.SUCCESS, symbolDto));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
