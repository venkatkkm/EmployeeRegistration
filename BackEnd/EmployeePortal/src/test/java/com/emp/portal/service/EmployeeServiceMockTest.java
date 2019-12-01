package com.emp.portal.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emp.portal.model.Employee;
import com.emp.portal.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceMockTest {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Test
	public void testRegisterEmployee() throws Exception {
		
		Employee mockEmployee = new Employee();
		mockEmployee.setId(1L);
		mockEmployee.setFirstName("ram");
		mockEmployee.setLastName("krishna");
		mockEmployee.setGender("male");
		mockEmployee.setDob(LocalDate.parse("1990-07-15"));
		mockEmployee.setDepartment("sale");
		
		Mockito.when(empRepository.save(mockEmployee)).thenReturn(mockEmployee);
	    
	    assertThat(empService.registerEmp(mockEmployee)).isEqualTo(mockEmployee);
	}
	
	@Test
	public void getAllEmployeeList(){

		Employee mockEmployee = new Employee();
		mockEmployee.setFirstName("ram");
		mockEmployee.setLastName("krishna");
		mockEmployee.setGender("male");
		mockEmployee.setDob(LocalDate.parse("1990-07-15"));
		mockEmployee.setDepartment("sale");
		
		Employee mockEmployee2 = new Employee();
		mockEmployee2.setFirstName("raj");
		mockEmployee2.setLastName("kiran");
		mockEmployee2.setGender("male");
		mockEmployee2.setDob(LocalDate.parse("1999-07-15"));
		mockEmployee2.setDepartment("IT");
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(mockEmployee);
		employeeList.add(mockEmployee2);
		
		Mockito.when(empService.getAllEmployees()).thenReturn(employeeList);
		
		assertThat(empService.getAllEmployees()).isEqualTo(employeeList);
	}
}