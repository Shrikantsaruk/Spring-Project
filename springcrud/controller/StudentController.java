package com.ty.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springcrud.dto.Login;
import com.ty.springcrud.dto.ResponseStructure;
import com.ty.springcrud.dto.Student;
import com.ty.springcrud.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping("/students")
	public ResponseStructure<List<Student>> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/student")
	public ResponseStructure<Login> validateStudent(@RequestBody Login login) {
		
		System.out.println(login.getEmail());
		return studentService.validateStudent(login);
	}

	@GetMapping("/students/{id}")
	public ResponseStructure<Student> getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@PutMapping("/students/{id}")
	public ResponseStructure<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

	@DeleteMapping("/students/{id}")
	public ResponseStructure<String> deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
}
