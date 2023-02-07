package servlet_complete_employe_project.service;

import servlet_complete_employe_project.dao.EmployeeDao;
import servlet_complete_employe_project.dto.Employee;

public class EmployeeService {
	EmployeeDao dao = new EmployeeDao();

	// insert
	public void insertEmployee(Employee employee) {
		dao.insertEmployee(employee);

	}

	// updateMethod
	public void updateEmployee(int id, Employee employee) {
		dao.updateEmployee(id, employee);
	}

	// GetById Method
	public int getById(int id) {
		return dao.getById(id);
	}

	// delete Method
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}
}
