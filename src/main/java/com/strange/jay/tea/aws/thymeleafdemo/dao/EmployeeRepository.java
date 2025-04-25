package com.strange.jay.tea.aws.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strange.jay.tea.aws.thymeleafdemo.entity.Employee;

import java.util.List;

/**
 * Spring Data JPA access to data.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Find all employees and sort by the last name.
     *
     * @return A non-null list of names sorted by last name.
     */
    public List<Employee> findAllByOrderByLastNameAsc();

}
