<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="./fileRouge.css" />
    
    </head>
    <body>
    
        <div>
            <form method="get" action="creationClient">
                <fieldset>
                    <legend>Informations client</legend>
   
    
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    
                   
                    <input type="text" id="nomClient" name="nomClient" value="${nom }" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value="<%=(String)request.getAttribute("prenom") %>" size="20" maxlength="20" />
                    <br />
    
                    <label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
                    <input type="text" id="adresseClient" name="adresseClient" value="<%=(String)request.getAttribute("adresse") %>" size="20" maxlength="20" />
                    <br />
    
                    <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="text" id="telephoneClient" name="telephoneClient" value="<%=(String)request.getAttribute("numero") %>" size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" value="<%=(String)request.getAttribute("mail") %>" size="20" maxlength="60" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>