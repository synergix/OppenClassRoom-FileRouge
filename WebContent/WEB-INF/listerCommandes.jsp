<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="/WEB-INF/Menu.jsp"></jsp:include>
 <table border="2">

		<thead>
			<th>Nom Client</th>
			<th>Prenom Client</th>
			<th>Date de la commande</th>
			<th>Montant commade</th>
			<th>Mode de paeiment</th>
			<th>Statut de Paeiment</th>
			<th>Mode de livraison</th>
			<th>Statut de livraison</th>
		</thead>

		<c:forEach var="commande" items="${ sessionScope.listeCommande}">
			<tr>
				<td>${commande.value.client.nom }</td>
				<td>${commande.value.client.prenom }</td>
				<td>${commande.value.dateCommande }</td>
				<td>${commande.value.montant }</td>
				<td>${commande.value.modePaiement }</td>
				<td>${commande.value.statuPaeiment }</td>
				<td>${commande.value.modeLivraison }</td>
				<td>${commande.value.statutLivraison }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>