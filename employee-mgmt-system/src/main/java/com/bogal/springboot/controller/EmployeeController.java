package com.bogal.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bogal.springboot.model.Employee;
import com.bogal.springboot.repository.EmployeeRepository;
import com.bogal.springboot.service.EmployeeService;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// display list of employees
	@GetMapping("/")
	public String viewEmployees(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	// Handle the creation of new employees
	@GetMapping("/showNewEmployeeForm")
	public String newEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	// Adding a new Employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return  "redirect:/";
	}
	
	// Handle the update of an employee
	@GetMapping("/showFormForUpdate/{id}")
	public String updateEmployeeForm(@PathVariable ( value = "id") Long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
		
//	// Updating a current Employee
//	@PostMapping("/saveEmployee/{id}")
//	public String updateEmployee(@PathVariable Long id,
//								 @ModelAttribute("employee") Employee employee,
//								 Model model) {
//		
//		Employee currentEmployee = employeeService.getEmployeeById(id);
//		currentEmployee.setId(id);
//		currentEmployee.setFirstName(employee.getFirstName());
//		currentEmployee.setLastName(employee.getLastName());
//		currentEmployee.setEmail(employee.getEmail());
//		
//		employeeService.updateEmployee(currentEmployee);
//		return  "redirect:/";
//	}
	
// Handle the update of an employee
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable ( value = "id") Long id) {
		Employee employeeToDelete = employeeService.getEmployeeById(id);
		
		employeeService.deleteEmployee(employeeToDelete) ;
		
		return "redirect:/";
	}

}
