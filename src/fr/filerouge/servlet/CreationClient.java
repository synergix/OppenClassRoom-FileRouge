package fr.filerouge.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.filerouge.client.Client;
import fr.filerouge.client.Utilisateurs;
import fr.filerouge.connexion.FormConnexion;

public class CreationClient extends HttpServlet {

	private static final String Accueil = "/accueil";
	private static final String LISTE_CLIENTS = "listeClients";
	private static final String URL_NOUVEAU_CLIENT = "/WEB-INF/Client.jsp";
	private static final String URL_LISTE_CLIENT = "/WEB-INF/listerClients.jsp";
	private Map<Integer, Client> listClientss = new HashMap<Integer, Client>();


	private static final String SESSION_UTILISATEUR = "utilisateurSession";
	public static final String COOKIE_DERNIERE_CONNEXION = "derneierConnexion";
	public static final String FORMAT_DATE = "dd/MM/yyy HH:mm:ss";
	public static final String INTERVALLE_CONNEXION = "intervalleConnexion";

	public CreationClient() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		HttpSession session = req.getSession();
		if (null!=session.getAttribute(SESSION_UTILISATEUR)) {
			req.getServletContext().getRequestDispatcher(URL_NOUVEAU_CLIENT).forward(req, resp);
		} else {
			this.getServletContext().getRequestDispatcher(Accueil).forward(req, resp);
		}

		

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nom = (String) req.getParameter("nomClient");
		String prenomClient = (String) req.getParameter("prenomClient");
		String adresseClient = (String) req.getParameter("adresseClient");
		String telephoneClient = (String) req.getParameter("telephoneClient");
		String emailClient = (String) req.getParameter("emailClient");
		Client client = new Client(nom, prenomClient, adresseClient, telephoneClient, emailClient);
		listClientss.put(client.getNumClient(), client);
		HttpSession session = req.getSession();
		session.setAttribute(LISTE_CLIENTS, listClientss);
		req.getServletContext().getRequestDispatcher(URL_LISTE_CLIENT).forward(req, resp);

	}
}
