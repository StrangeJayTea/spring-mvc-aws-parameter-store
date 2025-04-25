package com.strange.jay.tea.aws.thymeleafdemo.controller;

import java.util.List;

import com.strange.jay.tea.aws.thymeleafdemo.service.EmployeeService;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.strange.jay.tea.aws.thymeleafdemo.entity.Employee;

/**
 * Controller for REST endpoints to fill out the Thymeleaf template.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	/** List all employees. */
	private static final String LIST_EMPLOYEES = "employees/list-employees";

	/** Use a redirect to prevent duplicate submissions. */
	private static final String REDIRECT = "redirect:/employees/list";

	/** The form for adding or updating an employee. */
	private static final String EMPLOYEE_FORM = "employees/employee-form";

	/** Provides access to saved resources.*/
	private final EmployeeService employeeService;

	public EmployeeController(final EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}


	/**
	 * Show all employees saved to our repository.
	 *
	 * @param theModel UI model for showing the results.
	 * @return The template to call.
	 */
	@GetMapping("/list")
	public String listEmployees(final Model theModel) {
		LOGGER.info("list employees");
		final List<Employee> theEmployees = this.employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);

		return LIST_EMPLOYEES;
	}

	/**
	 * Create a form for adding a new employee.
	 * @param theModel UI model for adding a new employee.
	 * @return The template for showing the form to add a new employee.
	 */
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(final Model theModel) {
		LOGGER.info("add employee form");
		final Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);

		return EMPLOYEE_FORM;
	}

	/**
	 * Shows a form when a user wishes to update an employee's information.
	 * @param theId The unique ID for the employee to update.
	 * @param theModel UI model for the form to update the employee.
	 * @return The template for showing the form to update the employee.
	 */
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") final int theId,
									final Model theModel) {

		LOGGER.info("update employee with id {}", theId);
		final Optional<Employee> theEmployee = employeeService.findById(theId);
		if (theEmployee.isPresent()) {
			theModel.addAttribute("employee", theEmployee.get());
		} else {
			theModel.addAttribute("employee", new Employee());
		}

		return EMPLOYEE_FORM;
	}

	/**
	 * Saves a new employee and then redirects to the list of all employees.
	 * @param theEmployee The employee to save.
	 * @return The template to call after SAVE is done.
	 */
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") final Employee theEmployee) {
		LOGGER.info("saveEmployee {}", theEmployee.getFirstName());
		this.employeeService.save(theEmployee);
		return REDIRECT;
	}

	/**
	 * Deletes an employee and then redirects to the list of all employees.
	 * @param theId The unique ID for the employee entry to delete.
	 * @return The template to call after DELETE is done.
	 */
	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") final int theId) {
		LOGGER.info("delete employeeId {}", theId);
		this.employeeService.deleteById(theId);
		return REDIRECT;
	}
}









