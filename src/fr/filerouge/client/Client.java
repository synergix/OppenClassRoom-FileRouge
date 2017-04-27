package fr.filerouge.client;

import fr.cnrs.mdm.referentiel.common.dao.mock.RandomValue;

public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private String numero;
	private String mail;
	private String motDePass;
	private int numClient = RandomValue.getRandomInt(1, 10000000);

	public Client(String nom, String prenom, String adresse, String numero, String mail) {
		this.numClient = RandomValue.getRandomInt(1, 10000000);
		this.adresse = adresse;
		this.mail = mail;
		this.nom = nom;
		this.numero = numero;
		this.prenom = prenom;
	}

	public Client() {

	}

	public int getNumClient() {
		return numClient;
	}

	public String getMotDePass() {
		return motDePass;
	}

	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}

	public String getMail() {
		return mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNumero() {
		return numero;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {

		return getNom() + " - " + getNumClient();
	}
}
