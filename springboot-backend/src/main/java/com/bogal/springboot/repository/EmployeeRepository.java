package com.bogal.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bogal.springboot.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	

}
