<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Java EE</title>
  </head>
  <body>
  	<h1>Liste d'attente</h1>
  	<table border="1">
		<tbody>
			<c:forEach var="p" items="${rdv}">
				<tr>
					<td><c:out value="${p.civilite} ${p.nom} ${p.prenom}"/></td>
					<td>
						<fmt:formatDate type="date" dateStyle="long" value="${p.date}"/> à 
						<fmt:formatDate type="time" value="${p.date}"/>
					</td>				
					<c:if test="${p.urgent}">
						<td>
							<b>Rendez-vous urgent</b>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form method="post" accept-charset="utf-8">
  	<input type="hidden" id="sup" name="sup" value="suppression">
	<button name="suppresion">Supprimer</button>
  	</form>
	<div>
		<c:if test="${Place eq false}">
			<td>
				<b>Il n'y a plus de rendez-vous disponible !</b>
				
			</td>
		</c:if>
	  	<a href="<c:url value="/"/>">Retour à l'accueil</a>  
	</div>
  </body>
</html>
