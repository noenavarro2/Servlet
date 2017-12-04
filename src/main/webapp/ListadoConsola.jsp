<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Consolas</title>
</head>
<body>
	<form action="cargarListadoConsola" method="post">
		<input type="submit" value="ver listado">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>Nombre</td>
				<td>Empresa</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="consola" items="${consolas}">
				<tr>
					<td><c:out value="${consola.ID}" /></td>
					<td><c:out value="${consola.nombre}" /></td>
					<td><c:out value="${consola.empresa}" /></td>
					<td><a href="/delete?ID=${consola.ID}">borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>