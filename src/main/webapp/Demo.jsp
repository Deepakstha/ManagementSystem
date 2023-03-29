<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "model.Students" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Students studObj = new Students();
		studObj.setName("Objs");
		out.println(studObj.getName());
	%>
	
	<jsp:useBean id="st" class="model.Students" scope="page"/>
	<jsp:setProperty name="st" property="name" value="Deepak" />
	<h1><jsp:getProperty property="name" name="st"/> </h1>
	
</body>
</html>