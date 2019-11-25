package com.emp.portal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.portal.model.Employee;

@Service
public class EmployeeServiceHardCodedImpl implements EmployeeService{

	/*
	 * @Autowired private EmployeeRepository empRepository;
	 */

	private static List<Employee> empList = new ArrayList<Employee>();
	private static long idCounter = 0;

	static {
		empList.add(new Employee(++idCounter, "Ram","Krishna","male",LocalDate.parse("1995-07-15"), "Sales" ));
		empList.add(new Employee(++idCounter, "Jai","Shankar","male", LocalDate.parse("1994-08-20"),"IT" )); 
		empList.add(new Employee(++idCounter, "Ramya","Krishna","female",LocalDate.parse("1990-07-15"), "HR" )); 
	}

	@Override
	public Employee registerEmp(Employee emp) {
		if(emp.getId()==-1 || emp.getId()==0) {
			emp.setId(++idCounter);
			empList.add(emp);
		} 
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Collections.sort(empList,(e1,e2) -> e1.getFirstName().compareToIgnoreCase(e2.getFirstName()));
		return empList;
	}

}
