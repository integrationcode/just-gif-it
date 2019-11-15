package com.payroll.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@GetMapping(path = "/role/{roleName}")
	public ResponseEntity<EmployeeRole> getRoleByRoleName(@PathVariable String roleName) {
		System.out.println("["+this.getClass().getName()+"][getRoleByRoleName] parameter: " + roleName);
		return new ResponseEntity<EmployeeRole>(employeeRoleRepo.findByRoleName(roleName), HttpStatus.OK);		
	}
}
