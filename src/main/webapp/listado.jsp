<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de usuario</title>
</head>
<body>
<form action="cargarListado" method="post">
	<input type="submit" value="ver listado">
</form>


<table border="1">
	<thead>
		<tr>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Dni</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.nombre}"/> </td>
				<td><c:out value="${user.apellido}"/> </td>
				<td><c:out value="${user.dni}"/> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>