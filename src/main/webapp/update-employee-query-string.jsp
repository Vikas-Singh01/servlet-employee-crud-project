<%@page import="servlet_complete_employe_project.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Employee employee=(Employee)request.getAttribute("emp"); %>
	<form action="empUpdateQueryString" method="get">
	<label>Employee Id</label>
	<input type="text" name = "id" placeholder="enter emp Id" value="<%=employee.getEmpId()%>" hidden="true">
	<br><br>
	<label>Employee Name</label>
	<input type="text" name = "name" placeholder="Enter Your Name" value="<%=employee.getEmpName() %>">
	<br><br>
	<label>Employee Email</label>
	<input type="text" name = "email" placeholder="Enter Your Email" value="<%=employee.getEmpEmail() %>">
	<br><br>
		<label>Gender: </label>
		
	<input type="radio" name = "gender" value="male">&nbsp;
	<label>Male</label>
	
	<input type="radio" name = "gender" value="female">
	<label>FeMale</label>
	<br><br>
	<input type="submit" value="Update">
	</form>
</body>
</html>