package com.emp.portal.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.portal.model.Employee;
import com.emp.portal.repository.EmployeeRepository;

@Service
public class EmployeeServiceHardCodedImpl implements EmployeeService{

	@Autowired 
	private EmployeeRepository empRepository;


	public Employee registerEmp(Employee emp) {
		empRepository.save(emp);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = empRepository.findAll();
		Collections.sort(empList,(e1,e2) -> e1.getFirstName().compareToIgnoreCase(e2.getFirstName()));
		return empList;
	}

}
