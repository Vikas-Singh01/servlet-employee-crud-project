package servlet_complete_employe_project.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet_complete_employe_project.dto.Employee;
import servlet_complete_employe_project.service.EmployeeService;

@WebServlet("/EmployeeDetail")
public class EmployeeController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		Employee employee=new Employee();
		employee.setEmpId(id);
		employee.setEmpName(name);
		employee.setEmpEmail(email);
		employee.setEmpGender(gender);
		EmployeeService employeeService=new EmployeeService();
		PrintWriter printWriter=resp.getWriter();
		printWriter.write("<html><body>");
		employeeService.insertEmployee(employee);
		printWriter.write("<h3 style='color:green'>Data Inserted Succesfully</h3>");
		printWriter.write("</body></html>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("employee.jsp");
		dispatcher.include(req, resp);
	}
}
