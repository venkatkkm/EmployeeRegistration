package com.emp.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.portal.model.Employee;
import com.emp.portal.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping(path = "/register")
	public Employee registerEmpDetails(@RequestBody Employee emp) {
		return empService.registerEmp(emp);
	}

	@GetMapping(path = "/employees")
	public List<Employee> fetchAllEmployees() {
		return empService.getAllEmployees();
	}
}
