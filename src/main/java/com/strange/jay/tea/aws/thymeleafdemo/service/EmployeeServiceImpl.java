package com.strange.jay.tea.aws.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strange.jay.tea.aws.thymeleafdemo.dao.EmployeeRepository;
import com.strange.jay.tea.aws.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/** Access to the repository where employees are saved. */
	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(final EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Optional<Employee> findById(int theId) {
		return this.employeeRepository.findById(theId);
	}

	@Override
	public void save(Employee theEmployee) {
		this.employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		this.employeeRepository.deleteById(theId);
	}

}






