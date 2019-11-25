package com.emp.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.portal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
