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
<ul>

<li><a href="/FileRouge/creationClient">Créer nouveau client</a></li>
<li><a href="/FileRouge/creationCommande">Créer nouvelle commande</a></li>
<li><a href="#">Voir liste des commandes</a></li>
<li><a href="#">Voir liste des clients</a></li>
</ul>
<c:if test="${empty sessionScope.utilisateurSession  }">
Vous n'êtes pas connecté pour le moment veillez cliquer <a href="<c:url value="/connexion"></c:url>"> ici</a> pour vous connecter. Merci...

</c:if>
 <c:if test="${!empty  sessionScope.utilisateurSession}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${ sessionScope.utilisateurSession.mail}</p>
                </c:if>

</body>
</html>