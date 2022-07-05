<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo1.css">
<meta charset="utf-8">
<title>Editar Mov</title>
</head>
<body>
	<h1>Editar Movimentação</h1>
	<form name="frmMov" action="updateMov">
		<label>ID:</label>
		<input type="text" name="id" readonly value="<%out.print(request.getAttribute("id")); %>" >
		<br><br>
		<label>Nº Conteiner:</label>
		<input type="text" name="numero" pattern="^([A-Z]{4}[0-9]{7})$" required value="<%out.print(request.getAttribute("numero")); %>" >
		<br><br>
		<label>Tipo:</label>
		<select name="tipoMov">
			<option value="<%out.print(request.getAttribute("tipoMov")); %>">
				<%out.print(request.getAttribute("tipoMov")); %>
			</option>
			<option value="Embarque">Embarque</option>
			<option value="Descarga">Descarga</option>
			<option value="Gate In">Gate In</option>
			<option value="Gate Out">Gate Out</option>
			<option value="Reposicionamento">Reposicionamento</option>
			<option value="Pesagem">Pesagem</option>
			<option value="Scanner">Scanner</option>
		</select>
		<br><br>
		<label>Inicio:</label>
		<input type="datetime-local" name="inicio" required value="<%out.print(request.getAttribute("inicio")); %>" >
		<br><br>
		<label>Fim:</label>
		<input type="datetime-local" name="fim" required value="<%out.print(request.getAttribute("fim")); %>" >
		<input type="submit" value="Salvar">
	</form>
	
	<script src="scripts/validador.js"></script>
</body>
</html>