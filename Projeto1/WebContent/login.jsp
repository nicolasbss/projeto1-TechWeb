<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">  <%@include file="WEB-INF/form_style.css" %> </style>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>


<div class="login-page">
  <div class="form">
    <form class="login-form" action="AutenticaUsuario">
    <h3>Login</h3>
      <input type="text" name="login" placeholder="username"/>
      <input type="password" name="senha" placeholder="password"/>
      <input id="botao" type="submit" value="Entrar">
    </form>
    <p class="message">Not registered? <a href="/Projeto1/criapessoas.jsp">Create an account</a></p>
  </div>
</div>



</body>
</html>