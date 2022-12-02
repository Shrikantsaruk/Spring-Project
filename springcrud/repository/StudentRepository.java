package com.ty.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springcrud.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
