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

@WebServlet("/EmployeeUpdate")
public class EmployeeUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		Employee employee = new Employee();

		employee.setEmpName(name);
		employee.setEmpGender(gender);

		PrintWriter printWriter = resp.getWriter();
		printWriter.write("<html><body>");

		int idDatabase = service.getById(id);
		System.out.println("idDatabase = " + idDatabase + "\t" + "passingId = " + id);
		if (idDatabase != 0) {
			service.updateEmployee(id, employee);
			printWriter.write("<h3 style ='color:green'>Employee Name" + employee.getEmpName() + " and employeeGender"
					+ employee.getEmpGender() + " is updated successfully</h3>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("employeeUpdate.jsp");
			dispatcher.include(req, resp);

		} else {
			printWriter.write("<h3 style ='color:red'>Given Id" + id + " is not present</h3>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("employeeUpdate.jsp");
			dispatcher.include(req, resp);
		}
		printWriter.write("</body></html>");
	}
}
