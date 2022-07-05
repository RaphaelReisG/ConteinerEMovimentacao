<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo1.css">
<meta charset="utf-8">
<title>Editar Conteiner</title>
</head>
<body>
	<h1>Editar Conteiner</h1>
	<form name="frmConteiner" action="updateConteiner">
		<label>Nº Conteiner:</label>
		<input type="text" name="numero" readonly value="<%out.print(request.getAttribute("numero")); %>" >
		<br><br>
		<label>Cliente:</label>
		<input type="text" name="cliente"  pattern="[A-z ]*" required value="<%out.print(request.getAttribute("cliente")); %>" >
		<br><br>
		<label>Tipo:</label>
		<select name="tipo">
			<option value="<%out.print(request.getAttribute("tipo")); %>"><%out.print(request.getAttribute("tipo")); %></option>
			<option value="10">10</option>
			<option value="20">20</option>
		</select>
		<br><br>
		<label>Status:</label>
		<select name="estado">
			<option value="<%out.print(request.getAttribute("estado")); %>">
				<%out.print(request.getAttribute("estado")); %>
			</option>
			<option value="Cheio">Cheio</option>
			<option value="Vazio">Vazio</option>
		</select>
		<br><br>
		<label>Categoria:</label>
		<select name="categoria">
			<option value="<%out.print(request.getAttribute("categoria")); %>">
				<%out.print(request.getAttribute("categoria")); %>
			</option>
			<option value="Importação">Importação</option>
			<option value="Exportação">Exportação</option>
		</select>
		<br><br>
		<input type="submit" value="Salvar">
	</form>
	
	<script src="scripts/validador.js"></script>
</body>
</html>