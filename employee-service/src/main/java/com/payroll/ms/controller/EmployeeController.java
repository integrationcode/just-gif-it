package com.payroll.ms.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
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
	
	@Autowired
	Environment environment;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping(path = "/employee/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long empId) {
		try {
			System.out.println("["+InetAddress.getLocalHost().getHostName()+":"+environment.getProperty("local.server.port")+"]["+this.getClass().getName()+"][getEmployee] getById: " + empId);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("*** getEmployee With ID");
		return new ResponseEntity<Employee>(employeeRepo.findById(empId).get(),HttpStatus.OK);
		//return new Employee("Manoj","Verma",435579L,new Date());
	}
	
	@PostMapping(path = "/employee/")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
		
		try {
			System.out.println("["+InetAddress.getLocalHost().getHostName()+":"+environment.getProperty("local.server.port")+"]["+this.getClass().getName()+"][postEmployee] Insert: " + employee);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Employee>(employeeRepo.saveAndFlush(employee), HttpStatus.OK);
	}
	
	@GetMapping(path = "/employee/")
	public ResponseEntity<List<Employee>> getEmployee() {
		System.out.println("["+this.getClass().getName()+"][getEmployee] list");
		logger.info("*** getEmployee");
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("X-Status", "Working");
		return new ResponseEntity<List<Employee>>(employeeRepo.findAll(),responseHeader, HttpStatus.OK);
	}

}
