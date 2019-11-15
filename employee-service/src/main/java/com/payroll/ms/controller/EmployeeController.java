package com.payroll.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.ms.model.Employee;
import com.payroll.ms.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	@Qualifier("EmpRepo")
	EmployeeRepository employeeRepo;
	
	@GetMapping(path = "/employee/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long empId) {	
		System.out.println("["+this.getClass().getName()+"][getEmployee] getById: " + empId);
		return new ResponseEntity<Employee>(employeeRepo.findById(empId).get(),HttpStatus.OK);
		//return new Employee("Manoj","Verma",435579L,new Date());
	}
	
	@PostMapping(path = "/employee/")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
		System.out.println("["+this.getClass().getName()+"][postEmployee] Insert: " + employee);
		return new ResponseEntity<Employee>(employeeRepo.saveAndFlush(employee), HttpStatus.OK);
	}
	
	@GetMapping(path = "/employee/")
	public ResponseEntity<List<Employee>> getEmployee() {
		System.out.println("["+this.getClass().getName()+"][getEmployee] list");
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("X-Status", "Working");
		return new ResponseEntity<List<Employee>>(employeeRepo.findAll(),responseHeader, HttpStatus.OK);
	}

}
