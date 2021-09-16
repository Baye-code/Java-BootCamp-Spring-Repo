package com.bogal.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bogal.sms.entity.Student;
import com.bogal.sms.service.StudentService;


@Controller
public class StudentController {
	
	private StudentService studentService;	
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService ;
	}
	
	
	// handler method to handle list students and return mode and view
		@GetMapping("/students")
		public String listStudents(Model model) {
			model.addAttribute("students", studentService.getAllStudents());
			return "students";
		}
	
	// handler method to handle list students and add a student
		@GetMapping("/students/new")
		public String createStudentForm(Model model) {
			// Create student object to hold student form data
			Student student = new Student();
			model.addAttribute("student", student);
			return "create_student";
		}
		
		@PostMapping("/students")
		public String saveStudent(@ModelAttribute("student") Student student) {
			studentService.saveStudent(student);
			return "redirect:/students";
		}
		
		@GetMapping("/students/edit/{id}")
		public String editStudentForm(@PathVariable Long id, Model model) {
			model.addAttribute("student", studentService.getStudentById(id));
			return "edit_student";
		}
		
		@PostMapping("/students/{id}")
		public String updateStudent(@PathVariable Long id, 
									@ModelAttribute("student") Student student,
									Model model) {
			
			// get student from the database by id
			Student existingStudent = studentService.getStudentById(id);
			existingStudent.setId(id);
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setEmail(student.getEmail());
			
			// save updated student object
			studentService.updateStudent(existingStudent);
			return "redirect:/students";
		}
		
		@GetMapping("/students/{id}")
		public String deleteStudent(@PathVariable Long id) {
			
		// get student from the database by id
		Student studentToDelete = studentService.getStudentById(id);
		
		// save updated student object
		studentService.deleteStudent(studentToDelete);
		//studentService.deleteStudentById(id);
		
		return "redirect:/students";
			
		}

	
}