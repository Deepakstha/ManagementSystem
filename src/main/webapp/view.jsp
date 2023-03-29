<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "database.RegisterDao" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ include file="studentRegistration.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is jsp page</h1>
	<%
		RegisterDao rdao = new RegisterDao();
		ResultSet table = rdao.fetchStudentRecord();
		if(table != null){
	%>
			<table>
				<tr>

					<th>Fullname</th>
					<th>Department</th>
					<th>Phone</th>
					<th>Address</th>
					<th>Gender</th>
				</tr>
				<%
					while(table.next()){
						String fullname = table.getString("fullname");
						String department = table.getString("department");
						String phone = table.getString("phone");
						String address = table.getString("address");
						String gender = table.getString("gender");
						
				%>
				<tr>
					<td><%= fullname%></td>
					<td><%= department %></td>
					<td><%= phone %></td>
					<td><%= address %></td>
					<td><%= gender %></td>
				</tr>
				
				<%
					}
				%>
			</table>
	<%
		}else{
			out.println("<h1>Null</h1>");
			
		}
	%>
	

</body>
</html>