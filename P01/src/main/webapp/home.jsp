<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.JavaBeans" %>
<%@ page import="model.Conteiner" %>
<%@ page import="model.Movimentacao" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<Conteiner> listaConteiner = (ArrayList<Conteiner>) request.getAttribute("conteiners");

	ArrayList<Movimentacao> listaMov = (ArrayList<Movimentacao>) request.getAttribute("movimentacoes");
	/*
	for (int i = 0; i < lista.size(); i++){
		out.println(lista.get(i).getId());
		out.println(lista.get(i).getNome());
		out.println(lista.get(i).getFone());
	}*/
%>
    
<!DOCTYPE html>
<html lang = "pt-br">
<head>
<link rel="stylesheet" type="text/css" href="estilo1.css">
<meta charset="utf-8">
<title>Home</title>
</head>
<body>

	<h1>Conteiners e Movimentações</h1>
	<a class="botao" href="novoConteiner.html">Novo Conteiner</a>
	<a class="botao" href="novoMov.html">Nova Movimentação</a>
	
	<div class="conteudo">
		<h2>Conteiners</h2>
		<table>
			<thead>
				<tr>
					<th>Numero</th>
					<th>Cliente</th>
					<th>Tipo</th>
					<th>Status</th>
					<th>Categoria</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%for (int i=0; i<listaConteiner.size(); i++) {%>
					<tr>
						<td><%=listaConteiner.get(i).getNumero() %></td>
						<td><%=listaConteiner.get(i).getCliente() %></td>
						<td><%=listaConteiner.get(i).getTipo() %></td>
						<td><%=listaConteiner.get(i).getEstado() %></td>
						<td><%=listaConteiner.get(i).getCategoria() %></td>
						<td>
							<a class="botao" href="selectConteiner?numero=<%=listaConteiner.get(i).getNumero() %>">Editar</a>
							<button  class="botao"  onclick=confirmarConteiner("<%=listaConteiner.get(i).getNumero() %>")>
							 Excluir</button>
							
						</td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<h2>Movimentações</h2>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>Numero</th>
				<th>Tipo</th>
				<th>Inicio</th>
				<th>Fim</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i<listaMov.size(); i++) {%>
				<tr>
					<td><%=listaMov.get(i).getId() %></td>
					<td><%=listaMov.get(i).getNumero() %></td>
					<td><%=listaMov.get(i).getTipoMov() %></td>
					<td><%=listaMov.get(i).getInicio() %></td>
					<td><%=listaMov.get(i).getFim() %></td>
					<td>
						<a class="botao" href="selectMov?id=<%=listaMov.get(i).getId() %>">Editar</a>
						<button  class="botao"  onclick=confirmarMov("<%=listaMov.get(i).getId() %>")>
						 Excluir</button>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
	
</body>

<script src="scripts/confirmador.js"></script>
</html>