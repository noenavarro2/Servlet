<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Video Juegos</title>
</head>
<body>
	<form action="/mostrarlistado" method="post">
		<input type="submit" value="ver listado">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>Titulo</td>
				<td>Edad</td>
				<td>Fecha de lanzamiento</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="videojuego" items="${videojuegos}">
				<tr>
					<td><c:out value="${videojuego.ID}" /></td>
					<td><c:out value="${videojuego.titulo}" /></td>
					<td><c:out value="${videojuego.edadRecomendada}" /></td>
					<td><c:out value="${videojuego.fechaLanzamiento}" /></td>
					<td><a href="/delete?ID=${videojuego.ID}">borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<select>
		<c:forEach var="videojuego" items="${videojuegos}">
			<option value="${videojuego.titulo}">${videojuego.titulo}</option>
		</c:forEach>
	</select>

</body>
</html>