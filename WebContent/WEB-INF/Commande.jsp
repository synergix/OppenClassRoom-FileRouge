<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8" />

<title>Création d'une commande</title>

<link type="text/css" rel="stylesheet" href="inc/style.css" />

</head>

<body>
	<jsp:include page="/WEB-INF/Menu.jsp"></jsp:include>
	<div>
		<fieldset>

			<legend>Choix de saisie</legend>
			<form method="get" action="creationCommande">
				<label for="nouveauClient">Nouveau client <span
					class="requis">*</span></label> <input type="radio" name="nouveauClient"
					value="Oui" checked> Oui   <input type="radio"
					name="nouveauClient" value="Non"> Non<br>  <input
					type="submit" value="Valider le choix" />
			</form>
			<br />
		</fieldset>
		<form method="POST" action="creationCommande">


			<c:choose>
				<c:when test="${param.nouveauClient=='Oui' }">
<fieldset>

			<legend>Informations client</legend>
					<label for="nomClient">Nom <span class="requis">*</span></label>

					<input type="text" id="nomClient" name="nomClient" value=""
						size="20" maxlength="20" />

					<br />



					<label for="prenomClient">Prénom </label>

					<input type="text" id="prenomClient" name="prenomClient" value=""
						size="20" maxlength="20" />

					<br />



					<label for="adresseClient">Adresse de livraison <span
						class="requis">*</span></label>

					<input type="text" id="adresseClient" name="adresseClient" value=""
						size="20" maxlength="20" />

					<br />



					<label for="telephoneClient">Numéro de téléphone <span
						class="requis">*</span></label>

					<input type="text" id="telephoneClient" name="telephoneClient"
						value="" size="20" maxlength="20" />

					<br />



					<label for="emailClient">Adresse email</label>

					<input type="email" id="emailClient" name="emailClient" value=""
						size="20" maxlength="60" />

					<br />
		</fieldset>

		</c:when>
		<c:when test="${param.nouveauClient=='Non' }">

			<select id="clientOption">
				<c:forEach var="client" items="${ sessionScope.listeClients}">
					<option>${client.toString() }</option>
				</c:forEach>
			</select>

		</c:when>

		</c:choose>
		
				<fieldset>

					<legend>Informations commande</legend>



					<label for="dateCommande">Date <span class="requis">*</span></label>

					<input type="date" id="dateCommande" name="dateCommande" 
						size="20" maxlength="20"  /> <br /> <label
						for="montantCommande">Montant <span class="requis">*</span></label>

					<input type="text" id="montantCommande" name="montantCommande"
						value="" size="20" maxlength="20" /> <br /> <label
						for="modePaiementCommande">Mode de paiement <span
						class="requis">*</span></label> <input type="text"
						id="modePaiementCommande" name="modePaiementCommande" value=""
						size="20" maxlength="20" /> <br /> <label
						for="statutPaiementCommande">Statut du paiement</label> <input
						type="text" id="statutPaiementCommande"
						name="statutPaiementCommande" value="" size="20" maxlength="20" />

					<br /> <label for="modeLivraisonCommande">Mode de
						livraison <span class="requis">*</span>
					</label> <input type="text" id="modeLivraisonCommande"
						name="modeLivraisonCommande" value="" size="20" maxlength="20" />

					<br /> <label for="statutLivraisonCommande">Statut de la
						livraison</label> <input type="text" id="statutLivraisonCommande"
						name="statutLivraisonCommande" value="" size="20" maxlength="20" />

					<br />

				</fieldset>
			
		<input type="submit" value="Valider" /> <input type="reset"
			value="Remettre à zéro" /> <br />

		</form>

	</div>

</body>

</html>
