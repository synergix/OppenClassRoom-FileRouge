package fr.filerouge.commande;

import java.util.Date;
import java.util.Random;

import org.joda.time.DateTime;

import fr.cnrs.mdm.referentiel.common.dao.mock.RandomValue;
import fr.filerouge.client.Client;

public class Commande {
	private DateTime dateCommande;
	private int montant;
	private String modePaiement;
	private String modeLivraison;
	private String statutLivraison;
	private Client client;
	private String statuPaeiment;
	private int numCommande;

	public Commande(Client client, DateTime dateCommande, int montant, String modePaiement, String modeLivraison, String statutLivraison, String statuPaeiment) {
		this.numCommande = RandomValue.getRandomInt(1, 10000000);
		this.client = client;
		this.dateCommande = dateCommande;
		this.montant = montant;
		this.modeLivraison = modeLivraison;
		this.modePaiement = modePaiement;
		this.statutLivraison = statutLivraison;
		this.statuPaeiment = statuPaeiment;
	}

	public int getNumCommande() {
		return numCommande;
	}

	public String getStatuPaeiment() {
		return statuPaeiment;
	}

	public void setStatuPaeiment(String statuPaeiment) {
		this.statuPaeiment = statuPaeiment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public DateTime getDateCommande() {
		return dateCommande;
	}

	public int getMontant() {
		return montant;
	}

	public void setDateCommande(DateTime dateCommande) {
		this.dateCommande = dateCommande;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getModeLivraison() {
		return modeLivraison;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public String getStatutLivraison() {
		return statutLivraison;
	}

	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public void setStatutLivraison(String statutLivraison) {
		this.statutLivraison = statutLivraison;
	}

}
