package servlet_complete_employe_project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet_complete_employe_project.service.EmployeeService;
@WebServlet("/deleteEmployee")
public class EmployeeDeleteController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id =Integer.parseInt(req.getParameter("id"));
		EmployeeService employeeService=new EmployeeService();
		if(employeeService.getById(id)!=0)
		{
			employeeService.deleteEmployee(id);
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style ='color:green'>Employee of" +  id+  "is deleted");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("displayEmployee.jsp");
			requestDispatcher.include(req, resp);
		}
		else
		{
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style ='color:red'>Given Id" + id + " is not present</h3>");
			printWriter.write("</body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("displayEmployee.jsp");
			dispatcher.include(req, resp);	
		}
	
		
	
		
		
	}
}
