package com.bogal.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bogal.sms.entity.Student;
import com.bogal.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentMgtSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentMgtSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student student1 = new Student("Baye Sabarane", "LAM", "bayesabarane@gmail.com");
//		studentRepository.save(student1);
//		
//		Student student2 = new Student("Cheikh Tidiani", "Top", "tidiani97@gmail.com");
//		studentRepository.save(student2);
//		
//		Student student3 = new Student("Moustapha", "Diémé", "marshall95@gmail.com");
//		studentRepository.save(student3);
		
	}

}
