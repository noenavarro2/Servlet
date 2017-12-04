<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Alta de Videojuego</title>
</head>
<body>
	<form action="ListadoVideoJuego" method="post">
		<span>titulo:</span> 
		<input type="text" name="titulo"><br/>
		<span>edad recomendada:</span> 
		<br/>
		<input type="radio" id="edadRecomendada" name="edadRecomendada" value="siete">
		    <label for="edadRecomendada1">+7</label>
		<input type="radio" id="edadRecomendada" name="edadRecomendada" value="trece">
		    <label for="contactChoice2">+13</label>
		<input type="radio" id="edadRecomendada" name="edadRecomendada" value="dieciocho">
		    <label for="contactChoice2">+18</label>
		<span>Fecha de Lanzamiento:</span> 
		<input type="date" name="fechaLanzamiento"><br/>
		<input type="submit">
	</form>
	</body>
</html>