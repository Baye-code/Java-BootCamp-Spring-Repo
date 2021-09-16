package com.bogal.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bogal.springboot.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
