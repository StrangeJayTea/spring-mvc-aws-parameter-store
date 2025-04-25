package com.strange.jay.tea.aws.thymeleafdemo.service;

import java.util.List;

import com.strange.jay.tea.aws.thymeleafdemo.entity.Employee;
import java.util.Optional;

/**
 * Defines the service for finding, saving, and deleting Employee items.
 */
public interface EmployeeService {

	/**
	 * Find all employees in the repository.
	 *
	 * @return A non-null list of all employees.
	 */
	List<Employee> findAll();

	/**
	 * Finds an employee using its unique ID.
	 *
	 * @param theId The unique ID of the employee to locate.
	 * @return The employee, if found.
	 */
	Optional<Employee> findById(int theId);

	/**
	 * Saves or updates an employee.
	 *
	 * @param theEmployee
	 */
	void save(Employee theEmployee);

	/**
	 * Deletes an employee.
	 *
	 * @param theId Unique ID of the employee to delete.
	 */
	void deleteById(int theId);
	
}
