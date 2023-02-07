package servlet_complete_employe_project.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet_complete_employe_project.dao.EmployeeDao;
import servlet_complete_employe_project.dto.Employee;
@WebServlet("/updateEmployee")
public class EmployeeUpdateControllerQueryString extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao dao=new EmployeeDao();
		
		Employee employee = dao.getEmployeeById(id);
		
		if(employee!=null) {
			req.setAttribute("emp", employee);
			RequestDispatcher dispatcher=req.getRequestDispatcher("update-employee-query-string.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
