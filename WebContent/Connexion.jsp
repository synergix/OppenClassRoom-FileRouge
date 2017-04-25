<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="./fileRouge.css" />
    
    </head>
    <body>
    
        <div>
            <form method="post" action="connexion">
                <fieldset>
                    <legend>Informations client</legend>
   <c:if test="${empty sessionScope.utilisateurSession && !empty requestScope.intervalleConnexion}">
                	<p class="info">(Vous ne vous êtes pas connecté(e) depuis ce navigateur depuis ${requestScope.intervalleConnexion})</p>
                </c:if>

   
    
                    
                    <label for="email">Adresse email</label>
                    <input type="email" id="email" name="email" value="<c:out value="${utilisateur.mail}"/>" size="20" maxlength="60" />
                    <span>${form.erreurs['email'] }</span>
                    <br />
                     <label for="pwd">Mot de pass</label>
                    <input type="password" id="pwd" name="pwd" value="<c:out value="${utilisateur.motDePass}"/>" size="20" maxlength="60" />
                    <span>${form.erreurs['pwd'] }</span>
                    <br />
                    
                    <br />
                <label for="memoire">Se souvenir de moi</label>
                <input type="checkbox" id="memoire" name="memoire" />
                <br />
                    
                     <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                     <span> ${form.resultat }</span>
                     <c:if test="${!empty sessionScope.utilisateurSession}">
                <p>Vous êtes connecté avec: ${sessionScope.utilisateurSession.mail }</p>
                 </c:if>
                </fieldset>
               
               
               
               
            </form>
        </div>
    </body>
</html>