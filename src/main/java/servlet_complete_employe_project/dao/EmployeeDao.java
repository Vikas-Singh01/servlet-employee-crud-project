package servlet_complete_employe_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import servlet_complete_employe_project.dto.Employee;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// insert
	public void insertEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.out.println("Data Inserted........");
	}

	// updateMethod
	public void updateEmployee(int id, Employee employee) {
		Employee employee2 = entityManager.find(Employee.class, id);

		if (employee != null) {
			entityTransaction.begin();
			employee2.setEmpName(employee.getEmpName());
			employee2.setEmpGender(employee.getEmpGender());
			entityManager.merge(employee2);
			entityTransaction.commit();
		}
	}

	// GetById Method
	public int getById(int id) {
		Employee employee2 = entityManager.find(Employee.class, id);
		if (employee2 != null) {
			return employee2.getEmpId();
		} else {
			return 0;
		}
	}

	// display Method
	public List<Employee> displayEmployee() {
		String select = "Select e From Employee e";

		return entityManager.createQuery(select, Employee.class).getResultList();
	}

	// delete Method
	public void deleteEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
	}

	// getEmployeeById By QueryString
	public Employee getEmployeeById(int id) {

		Employee employee2 = entityManager.find(Employee.class, id);

		if (employee2 != null) {
			return employee2;

		} else {
			return null;
		}
	}
	//update method for query string
		public void updateEmployeeByQueryString(int id, Employee employee) {
			
			Employee employee2 = entityManager.find(Employee.class, id);
			
			if((employee.getEmpName() != null) && (employee.getEmpGender() != null)) {
				
				employee2.setEmpName(employee.getEmpName());
				employee2.setEmpGender(employee.getEmpGender());
				entityTransaction.begin();
				entityManager.merge(employee2);
				entityTransaction.commit();
			}
		}
}
