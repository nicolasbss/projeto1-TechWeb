<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">  <%@include file="WEB-INF/form_style.css" %> </style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*,br.edu.insper.techweb.projeto1.*" %>
	
<div class="login-page">
	<div class="form">
    <form class="login-form" action = "AlteraCredenciais" method="POST">
    	<% int id = (Integer) request.getAttribute("idNota");
		int pessoa_id = (Integer) request.getAttribute("pessoa_id");%>
    <h3>Alterar Credenciais</h3>
      <input type="text" name="login" placeholder="Novo login"/>
      <input type="password" name="senha" placeholder="Nova senha"/>
      <input type ="hidden" name = "pessoa_id" value=<%=pessoa_id %>>
      <input id="botao" type="submit" value="Mudar">
    </form>
	</div>
</div>
</body>
</html>