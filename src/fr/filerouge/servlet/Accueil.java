package fr.filerouge.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Accueil extends HttpServlet {
	private static final String ACCUEIL = "/WEB-INF/Menu.jsp";



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		this.getServletContext().getRequestDispatcher(ACCUEIL).forward(req, resp);
	}
}
