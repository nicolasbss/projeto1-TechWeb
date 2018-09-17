<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">  <%@include file="WEB-INF/style.css" %> </style>
<link  href="http://fonts.googleapis.com/css?family=Reenie+Beanie:regular" rel="stylesheet"type="text/css">

<head>
<%@ page import="java.util.*,br.edu.insper.techweb.projeto1.*" %>

<%	DAO dao = new DAO();
	
	int id_usuario = (Integer) request.getAttribute("usuario");
	List<Notas> listaNotas = dao.getListaNotas(id_usuario); %>
</head>
<body>	
	<ul>
		<% for (Notas nota : listaNotas) { %>
		<li><a href= '#'>
			<h2>Nota</h2>
			<p><%=nota.getConteudo()%></p>		
			<form action = "RemoveNota" method = "post"><br>
				<input type='hidden' name='id' value="<%= nota.getId()%>">
				<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
				<input type = "submit" value = "Delete essa nota">
			</form>
			<form action = "AtualizaNotas"><br>
				<input type='hidden' name='id' value="<%= nota.getId()%>">
				<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
				<input type = "submit" value = "Atualize essa nota">
			</form>
			</a>
		</li>
		<% } %>
	</ul>
	
	<form action = "CriaNotas" method = "get">
		<input type = "hidden" value =<%= id_usuario %> name = "pessoa_id">
		<input type = "submit" value = "Crie uma nota">
	</form>
	
	<form action="AlteraCredenciais">
		
		<input type="hidden" name='pessoa_id' value=<%=id_usuario %>>
		<input type ="submit" value="Alterar login e senha">
	</form>
	
</body>
</html>