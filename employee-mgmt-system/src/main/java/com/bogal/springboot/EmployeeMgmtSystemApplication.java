package com.bogal.springboot;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bogal.springboot.model.Employee;
import com.bogal.springboot.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeMgmtSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtSystemApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
//			
//		Employee emp1 = new Employee("Baye Sabarane", "LAM", "bayesabarane@gmail.com");
//		employeeRepository.save(emp1);
//		
//		Employee emp2 = new Employee("Cheikh Tidiani", "Top", "tidiani97@gmail.com");
//		employeeRepository.save(emp2);
//		
//		Employee emp3 = new Employee("Moustapha", "Diémé", "marshall95@gmail.com");
//		employeeRepository.save(emp3);
//		
//		Employee emp4 = new Employee("Dieynaba", "Dhiediou", "gnima52@gmail.com");
//		employeeRepository.save(emp4);
//		
//		Employee emp5 = new Employee("Cheikh", "Sougou", "sougou72@gmail.com");
//		employeeRepository.save(emp5);
//		
//		Employee emp6 = new Employee("Ousmane", "Sanokho", "sanokho95@gmail.com");
//		employeeRepository.save(emp6);
//		
//		Employee emp7 = new Employee("Abdoulaye", "Ndiaye", "ndiaye89@gmail.com");
//		employeeRepository.save(emp7);
//		
//		Employee emp8 = new Employee("Bamba", "Ndour", "ndourbamba78@gmail.com");
//		employeeRepository.save(emp8);
			
		}

}
