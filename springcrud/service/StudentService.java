package com.ty.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.springcrud.dao.StudentDao;
import com.ty.springcrud.dto.Login;
import com.ty.springcrud.dto.ResponseStructure;
import com.ty.springcrud.dto.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;

	public ResponseStructure<Student> saveStudent(Student student){
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		if(student!=null) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Student saved");
		responseStructure.setData(studentDao.saveStudent(student));
		}else {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Student not saved");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<Login> validateStudent(Login login){
		String email=login.getEmail();
		String password=login.getPassword();
		
				ResponseStructure<Login> responseStructure=new ResponseStructure<Login>();
				boolean flag=studentDao.validateStudent(email,password);
		if(flag) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Student Login successfully");
		responseStructure.setData(login);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student Login failed");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	
	public ResponseStructure<List<Student>> getAllStudent(){
		List<Student> students=studentDao.getAllStudent();
		ResponseStructure<List<Student>> responseStructure=new ResponseStructure<List<Student>>();
		if(students!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(students);
		}else {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Not Success");
			responseStructure.setData(null);
			
		}
		return responseStructure;
	}
	
	public ResponseStructure<Student> getStudentById(int id){
		Student student=studentDao.getStudentById(id);
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		if(student!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(student);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student not found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<Student> updateStudent(int id,Student student){
		Student student2=studentDao.getStudentById(id);
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		if(student2!=null) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(studentDao.updateStudent(id,student));
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student not found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
	public ResponseStructure<String> deleteStudent(int id){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		boolean flag = studentDao.deleteStudent(id);
		if (flag) {
			responseStructure.setData("Data deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Teacher not found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	
}
