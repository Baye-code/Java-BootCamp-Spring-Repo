package com.bogal.springboot.service;

import java.util.List;
import com.bogal.springboot.model.Employee;


public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(Long id);
	
	void deleteEmployee(Employee employee);

}
