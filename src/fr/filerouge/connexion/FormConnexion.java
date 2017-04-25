package fr.filerouge.connexion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.filerouge.client.Client;

public class FormConnexion {
	private final String CHAMPS_EMAIL = "email";
	private final String CHAMPS_PWD = "pwd";
	private Map<String, String> erreurs = new HashMap<String, String>();

	private String resultat;

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}

	public void setErreurs(String champ, String valeur) {
		this.erreurs.put(champ, valeur);
	}

	public Client getUtilisateur(HttpServletRequest request) {

		Client utilisateur = new Client();

		String email = getValeurChamps(request, CHAMPS_EMAIL);
		String pwd = getValeurChamps(request, CHAMPS_PWD);
		try {

			validationEmail(email);
		} catch (Exception e) {
			setErreurs(CHAMPS_EMAIL, e.getMessage());
		}
		utilisateur.setMail(email);

		try {

			validationMotDePasse(pwd);
		} catch (Exception e) {
			setErreurs(CHAMPS_PWD, e.getMessage());
		}
		utilisateur.setMotDePass(pwd);
		if (erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}
		return utilisateur;
	}

	/**
	 * Valide l'adresse email saisie.
	 */
	private void validationEmail(String email) throws Exception {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	}

	private String getValeurChamps(HttpServletRequest request, String champ) {
		String valeur = request.getParameter(champ);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}

	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse) throws Exception {
		if (motDePasse != null) {
			if (motDePasse.length() < 3) {
				throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}

}
