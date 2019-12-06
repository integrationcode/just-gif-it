package com.boot.SBTestApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.SBTestApp.model.Student;
import com.boot.SBTestApp.service.StudentService;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
	
	@Autowired
	@Qualifier(value = "myStudentService")
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> list(){
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("x_type", "list");
		return new ResponseEntity<List<Student>>(service.getAllStudents(), responseHeader, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Student> list(@PathVariable Long id){
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("x_type", "list with id");
		return new ResponseEntity<Student>(service.getStudentById(id), responseHeader, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> add(@RequestBody Student student){
		return new ResponseEntity<Student>(service.create(student), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public HttpStatus delete(@PathVariable Long id){
		service.delete(id);
		return HttpStatus.OK;
	}
}
