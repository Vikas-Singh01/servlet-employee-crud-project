<%@page import="servlet_complete_employe_project.dto.Employee"%>
<%@page import="java.util.List"%>
<%@page import="servlet_complete_employe_project.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style='background-color:orange'>
<% EmployeeDao employeeDao=new EmployeeDao();
	List<Employee> employees=employeeDao.displayEmployee();
%>	
	<table border="2">
		<tr>
			<th>empId</th>
			<th>empName</th>
			<th>empEmail</th>
			<th>empGender</th>
			<th>Delete</th>
			<th>update</th>
		</tr>
		<% for(Employee employee:employees){ %>
		<tr>
			<td><%=employee.getEmpId() %></td>
			<td><%=employee.getEmpName() %></td>
			<td><%=employee.getEmpEmail() %></td>
			<td><%=employee.getEmpGender() %></td>			
			<td><a href="deleteEmployee?id=<%=employee.getEmpId()%>">Delete</a></td>
			<td><a href="updateEmployee?id=<%=employee.getEmpId()%>">Update</a></td>	
		</tr>
		<%}%>
	</table>
</body>
</html>