<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.util.*,br.edu.insper.techweb.projeto1.*" %>
	<form action = "AtualizaNotas" method="POST">
		<% int id = (Integer) request.getAttribute("idNota");
			int pessoa_id = (Integer) request.getAttribute("pessoa_id");%>
   		Tipo: <select name='tipo'><option value='texto'>Texto </option></select><br>
    	Conteudo: <input type='text' name='conteudo'><br>
    	<input type ="hidden" name = "id" value= <%=id %>>
    	<input type ="hidden" name = "pessoa_id" value=<%=pessoa_id %>>
   		<input type='submit' value='Submit'>
    </form>
</body>
</html>