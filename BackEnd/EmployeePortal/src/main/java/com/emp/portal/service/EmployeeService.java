package com.emp.portal.service;

import java.util.List;

import com.emp.portal.model.Employee;

public interface EmployeeService {

	Employee registerEmp(Employee emp);

	List<Employee> getAllEmployees();

}
