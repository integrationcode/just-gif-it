package com.payroll.ms.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.ms.Repository.EmployeeRoleRepository;
import com.payroll.ms.model.EmployeeRole;

@RestController
public class EmployeeRoleController {
	
	@Autowired
	@Qualifier("EmpRoleRepo")
	private EmployeeRoleRepository employeeRoleRepo;
	
	@Autowired
	Environment environment;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeRoleController.class);

	@GetMapping(path = "/role/{roleName}")
	public ResponseEntity<EmployeeRole> getRoleByRoleName(@PathVariable String roleName) {
		try {
			System.out.println("["+InetAddress.getLocalHost().getHostName()+":"+environment.getProperty("local.server.port")+"]["+this.getClass().getName()+"][getRoleByRoleName] parameter: " + roleName);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("** getRoleByRoleName");
		return new ResponseEntity<EmployeeRole>(employeeRoleRepo.findByRoleName(roleName), HttpStatus.OK);		
	}
	
	@GetMapping(path="/role/")
	public ResponseEntity<List<EmployeeRole>> getRoles(){
		System.out.println("["+this.getClass().getName()+"][getRoles]");
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("X-Resposne-Code", "Working!");
		logger.info("** getRoles");
		return new ResponseEntity<List<EmployeeRole>>(employeeRoleRepo.findAll(),responseHeader, HttpStatus.OK);
	}
}
