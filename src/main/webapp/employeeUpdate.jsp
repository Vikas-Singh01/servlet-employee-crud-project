<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style='background-color:pink'>
<h1>Employee Form</h1>
	<form action="EmployeeUpdate">
	<label>Employee Id</label>
	<input type="text" name = "id">
	<br><br>
	<label>Employee Name</label>
	<input type="text" name = "name" placeholder="Enter Your Name">
	<br><br>
	<label>Employee Email</label>
	<input type="text" name = "email" placeholder="Enter Your Email">
	<br><br>
	<label>Gender: </label>	
	<input type="radio" name = "gender" value="male">
	<label>Male</label>
	<input type="radio" name = "gender" value="female">
	<label>FeMale</label>
	<br><br>
	<input type="submit" value="Ragister">
	</form>
</body>
</html>