package fr.filerouge.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.joda.time.DateTime;

import fr.filerouge.client.Client;
import fr.filerouge.commande.Commande;

public class CreationCommande extends HttpServlet {

	private static final String URL_NOUVELLE_COMMENDE = "/WEB-INF/Commande.jsp";
	private static final String Accueil = "/WEB-INF/Menu.jsp";
	private static final String SESSION_UTILISATEUR = "utilisateurSession";
	private static final String URL_LISTE_COMMANDE = "/WEB-INF/listerCommandes.jsp";
	private static final String LISTE_COMMANDE = "listeCommande";
	private Map<Integer,Commande> listCommandes=new HashedMap<Integer,Commande>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (null!=session.getAttribute(SESSION_UTILISATEUR)) {
			this.getServletContext().getRequestDispatcher(URL_NOUVELLE_COMMENDE).forward(req, resp);
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
		if(req.getParameter("clientOption")!=null) {
			
		}
		Client client = new Client(nom, prenomClient, adresseClient, telephoneClient, emailClient);
		
		DateTime dateCommande = DateTime.parse(req.getParameter("dateCommande"));
		int montantCommande =  Integer.parseInt(req.getParameter("montantCommande"));
		String modePaiementCommande = (String) req.getParameter("modePaiementCommande");
		String statutPaiementCommande = (String) req.getParameter("statutPaiementCommande");
		String modeLivraisonCommande=(String)req.getParameter("modeLivraisonCommande");
		String statutLivraisonCommande=(String)req.getParameter("statutLivraisonCommande");
	
		Commande commande = new Commande(client,dateCommande,montantCommande,modePaiementCommande,modeLivraisonCommande,statutLivraisonCommande,statutPaiementCommande);
		listCommandes.put(commande.getNumCommande(), commande);
		HttpSession session = req.getSession();
		
		
		if(session.getAttribute("listeClients")==null) {
			session.setAttribute("listeClients", new HashedMap<Integer,Client>());
		}
		Map<Integer,Client> listeClient=(Map<Integer, Client>) session.getAttribute("listeClients");
		if (client!=null) {
		listeClient.put(client.getNumClient(), client);
		}
		session.setAttribute(LISTE_COMMANDE, listCommandes);
		req.getServletContext().getRequestDispatcher(URL_LISTE_COMMANDE).forward(req, resp);
	}
}
