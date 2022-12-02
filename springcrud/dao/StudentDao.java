package com.ty.springcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springcrud.dto.Login;
import com.ty.springcrud.dto.Student;
import com.ty.springcrud.repository.StudentRepository;

@Repository
public class StudentDao {

	
	@Autowired
	StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	public Student updateStudent(int id, Student student) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return studentRepository.save(student);
		}
	}
	
	public boolean validateStudent(String email,String password) {
		List<Student>students=getAllStudent();
		for (Student student2 : students) {
			if(student2.getEmail().equals(email) && student2.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	
	
	public Student getStudentById(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}
	public boolean deleteStudent(int id) {
		Optional<Student>optional=studentRepository.findById(id);
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
			return true;
		}
		return false;
	}
}
