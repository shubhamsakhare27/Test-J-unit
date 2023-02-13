package com.TestExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TestExample.model.Student;

@RestController
public class StringController {

	@Autowired
	com.TestExample.repository.StudentRepository studentRepository;

	@GetMapping("/endpoint")
	public ResponseEntity<String> endpointMethod() {
	       return ResponseEntity.ok("shubham");
	}

	@GetMapping("/endpoint2")
	public ResponseEntity<Student> endpointMethod2() {
		Student student = new Student();
		student.setId(1);
		student.setName("shubham");
		student.setDomain("IT");
        return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping("/endpoint3")
	public ResponseEntity<List<Student>> endpointMethod3() {
		List<Student> students = studentRepository.findAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
    }
     
}
