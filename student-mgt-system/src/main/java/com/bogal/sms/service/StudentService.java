package com.bogal.sms.service;

import java.util.List;
import com.bogal.sms.entity.Student;


public interface StudentService {
	
	List<Student> getAllStudents();

	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
	
	void deleteStudent(Student student);

}
