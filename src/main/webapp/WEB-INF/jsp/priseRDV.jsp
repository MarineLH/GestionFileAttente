<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Java EE</title>
    <style type="text/css">
    	form > div {
    		padding: .5em;
    	}
    	
    	div > label:first-child {
    		display: inline-block;
			min-width: 18em;
		}
		
		.error {
			color: red;
		}
    </style>
  </head>
  <body>

	<form method="post" accept-charset="utf-8">
	<input type="hidden" id="sup" name="sup" value="rien">
		<div>
			<label for="civilite">Civilité : </label>		
			<select id="civilite" name="civilite">
          		<option value="Madame">Madame</option>
          		<option value="Monsieur">Monsieur</option>
     		</select>
			<span class="error"><c:out value="${errors['civilite']}"/></span>
		</div>
		<div>
			<label for="nom">Nom : </label>
			<input id="nom" name="nom" type="text">
			<span class="error"><c:out value="${errors['nom']}"/></span>
		</div>
		<div>
			<label for="prenom">Prénom : </label>
			<input id="prenom" name="prenom" type="text">
			<span class="error"><c:out value="${errors['prenom']}"/></span>
		</div>
		<div>
			<input id="urgent" name="urgent" value="true" type="checkbox">
			<label for="urgent">Rendez-vous urgent</label>
			<span class="error"><c:out value="${errors['urgent']}"/></span>
		</div>
		<div>
			<button type="submit">Prendre rdv</button>
		</div>
	</form>

	<div>
	  	<a href="<c:url value="/"/>">Retour à l'accueil</a>  
	</div>
  
  </body>
</html>