<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%if(request.getAttribute("LoginMessage") != null){ %>
<h1><%= request.getAttribute("LoginMessage")  %> </h1>
<%} %>
	<form action="Login">
		<h1>Login</h1>
		id: <br/> <input type="text" name="id" /> <br/><br/>
		fullname: <br/> <input type="text" name = "fullname"/> <br/><br/>
		<input type= "submit" />
	</form>
</body>
</html>