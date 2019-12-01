package com.emp.portal.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.emp.portal.model.Employee;
import com.emp.portal.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=EmployeeControllerTest.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService empService;
	
	@Test
	public void testRegisterEmployee() throws Exception {
		
		Employee mockEmployee = new Employee();
		mockEmployee.setId(1L);
		mockEmployee.setFirstName("ram");
		mockEmployee.setLastName("krishna");
		mockEmployee.setGender("male");
		mockEmployee.setDob(LocalDate.parse("1990-07-15"));
		mockEmployee.setDepartment("sale");
		
		String inputInJson = this.mapToJson(mockEmployee);
		
		String URI = "/register";
		
		Mockito.when(empService.registerEmp(Mockito.any(Employee.class))).thenReturn(mockEmployee);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void getAllEmployeeList() throws Exception {

		Employee mockEmployee = new Employee();
		mockEmployee.setId(1L);
		mockEmployee.setFirstName("ram");
		mockEmployee.setLastName("krishna");
		mockEmployee.setGender("male");
		mockEmployee.setDob(LocalDate.parse("1990-07-15"));
		mockEmployee.setDepartment("sale");
		
		Employee mockEmployee2 = new Employee();
		mockEmployee2.setId(2L);
		mockEmployee2.setFirstName("raj");
		mockEmployee2.setLastName("kiran");
		mockEmployee2.setGender("male");
		mockEmployee2.setDob(LocalDate.parse("1999-07-15"));
		mockEmployee2.setDepartment("IT");
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(mockEmployee);
		employeeList.add(mockEmployee2);
		
		Mockito.when(empService.getAllEmployees()).thenReturn(employeeList);
		
		String URI = "/employees";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(employeeList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
