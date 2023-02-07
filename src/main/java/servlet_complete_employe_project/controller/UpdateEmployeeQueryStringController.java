package servlet_complete_employe_project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_complete_employe_project.dao.EmployeeDao;
import servlet_complete_employe_project.dto.Employee;

@WebServlet("/empUpdateQueryString")
public class UpdateEmployeeQueryStringController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id =Integer.parseInt(req.getParameter("id"));
		
		String name = req.getParameter("name");
		
		String gender = req.getParameter("gender");
		
		Employee employee = new Employee();
		employee.setEmpName(name);
		employee.setEmpGender(gender);	
		EmployeeDao dao = new EmployeeDao();
		dao.updateEmployeeByQueryString(id, employee);
		PrintWriter printWriter=resp.getWriter();
		printWriter.write("<html><body>");
		printWriter.write("<h3 style ='color:green'>Employee Name" + employee.getEmpName() + " and employeeGender"
				+ employee.getEmpGender() + " is updated successfully</h3>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("displayEmployee.jsp");
		dispatcher.include(req, resp);
		printWriter.write("</body></html>");

	}
}
