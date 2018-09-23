package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {

	public Employee save(Employee employee);

	public Employee findById(int id);

	public List<Employee> findAll();

	public void remove(int id);
}
