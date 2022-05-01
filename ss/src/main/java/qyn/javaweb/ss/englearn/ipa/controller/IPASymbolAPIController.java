package qyn.javaweb.ss.englearn.ipa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import qyn.javaweb.ss.englearn.ipa.dao.IPASymbolDAO;
import qyn.javaweb.ss.englearn.ipa.model.IPASymbol;

/**
 * Servlet implementation class IPASymbolController
 */
public class IPASymbolAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPASymbolAPIController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		IPASymbol symbol = IPASymbolDAO.getById(id);
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
