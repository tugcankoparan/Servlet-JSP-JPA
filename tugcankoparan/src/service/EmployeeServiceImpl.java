package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl() {
		employeeDAO = new EmployeeDAOImpl();
	}

	private void checkSalary(Employee employee) {

		if (employee.getSalary() < 100) {
			throw new RuntimeException("Invalid Salary");
		}
	}


	private void checkEmployeeData(Employee employee) {
		checkSalary(employee);
	}

	@Override
	public Employee save(Employee employee) {
		checkEmployeeData(employee);
		return employeeDAO.save(employee);
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public void remove(int id) {
		employeeDAO.remove(id);
	}

}
