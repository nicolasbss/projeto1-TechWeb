<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% int id_usuario = (Integer) request.getAttribute("pessoa_id");%>
	<form action = "CriaNotas" method='post'>
		Selecione o tipo da sua nota: <select name='tipo'><option value='texto'> Texto </option></select><br> 
		Digite sua nota: <input type='text' name='conteudo'><br>
		<input type = "hidden" value =<%=id_usuario %> name = "pessoa_id">
		<input type='submit' value='Submit'>
	</form>
</body>
</html>