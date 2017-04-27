<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<th>Adresse Client</th>
			<th>Numero Client</th>
			<th>Email Client</th>
		</thead>

		<c:forEach var="client" items="${ sessionScope.listeClients}">
			<tr>
				<td>${client.value.nom }</td>
				<td>${client.value.prenom }</td>
				<td>${client.value.adresse }</td>
				<td>${client.value.numero }</td>
				<td>${client.value.mail }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>