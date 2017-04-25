package fr.filerouge.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.filerouge.client.Client;

public class FileRougeServlet extends HttpServlet {
private String nom;
	public FileRougeServlet() {
		
	}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Client client=new Client();//"Camara", "Youssouf", "2 rue des daims", "03.02.05.03.36", "ycamara@test.fr");
	this.nom=client.getNom();
	req.setAttribute("nom", client.getNom());
	req.setAttribute("prenom", client.getPrenom());
	req.setAttribute("adresse", client.getAdresse());
	req.setAttribute("numero", client.getNumero());
	req.setAttribute("mail", client.getMail());
	this.getServletContext().getRequestDispatcher("/Client.jsp").forward(req, resp);
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}

}
