package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Employee;
import utility.EntityManagerUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee save(Employee employee) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		return employee;
	}

	@Override
	public Employee findById(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.close();
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Employee> typedQuery = entityManager.createQuery("Select e from Employee e", Employee.class);
		List<Employee> employees = typedQuery.getResultList();
		entityManager.close();
		return employees;
	}

	@Override
	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(employee);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

}
