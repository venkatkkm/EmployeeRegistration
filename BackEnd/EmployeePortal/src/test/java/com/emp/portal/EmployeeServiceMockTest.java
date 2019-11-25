package com.emp.portal;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Assert;

import com.emp.portal.model.Employee;
import com.emp.portal.service.EmployeeService;
import com.emp.portal.service.EmployeeServiceHardCodedImpl;

public class EmployeeServiceMockTest {

	@Mock
	EmployeeService empService;
	
	@InjectMocks
	EmployeeServiceHardCodedImpl empServiceImpl;
	
	@Test
	public void testGetAllEmployees() {
		Assert.assertEquals("EmpServiceCall",empServiceImpl.getAllEmployees().size(), 3);
		
	}
}
