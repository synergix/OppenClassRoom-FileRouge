package fr.filerouge.commande;

import java.util.Date;

public class Commande {
	private Date dateCommande;
	private int montant;
	private String modePaiement;
	private String modeLivraison;
	private String statutLivraison;

	public Commande(Date dateCommande, int montant, String modePaiement, String modeLivraison, String statutLivraison) {
		this.dateCommande = dateCommande;
		this.montant = montant;
		this.modeLivraison = modeLivraison;
		this.modePaiement = modePaiement;
		this.statutLivraison = statutLivraison;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public int getMontant() {
		return montant;
	}

	public void setDateCommande(Date dateCommande) {
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
