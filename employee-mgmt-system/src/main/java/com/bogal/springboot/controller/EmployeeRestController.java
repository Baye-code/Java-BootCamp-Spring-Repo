package com.bogal.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bogal.springboot.model.Employee;
import com.bogal.springboot.repository.EmployeeRepository;
import com.bogal.springboot.service.EmployeeService;


@Controller
public class EmployeeRestController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		
		return employees;
	}
	
	@GetMapping(path="/employees/{id}", produces = "application/xml")
	@ResponseBody
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		//Employee employee = employeeRepo.getOne(id);
		//Employee employee = employeeService.getEmployeeById(id);
		Employee employee = employeeRepo.findById(id).orElse(new Employee("NotDefined", "NotDefined", "NotDefined"));
		return employee;
	}
	
	@PostMapping(path="/employee", consumes = {"application/json"})
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee employee) {
		//employeeService.saveEmployee(employee);
		employeeRepo.save(employee);
		return employee;
	}

}
