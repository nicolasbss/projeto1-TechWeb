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
	<form action = "AlteraCredenciais" method="POST">
		<% int id = (Integer) request.getAttribute("idNota");
			int pessoa_id = (Integer) request.getAttribute("pessoa_id");%>
   		Novo login: <input type='text' name='login'>
    	Nova senha: <input type='password' name='senha'><br>
    	<input type ="hidden" name = "pessoa_id" value=<%=pessoa_id %>>
   		<input type='submit' value='Submit'>
   	</form>
</body>
</html>