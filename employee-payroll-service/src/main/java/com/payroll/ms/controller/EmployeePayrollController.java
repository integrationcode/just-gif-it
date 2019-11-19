package com.payroll.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.payroll.ms.model.EmployeePayroll;
import com.payroll.ms.repository.EmployeePayrollRepository;
import com.payroll.ms.service.EmployeeService;
import com.payroll.ms.service.RoleService;

@RestController
public class EmployeePayrollController {

	@Autowired
	private EmployeePayrollRepository empPayrollRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/employee/{empId}/role/{roleName}")
	public void insertEmployeePayrollDetails(@PathVariable Long empId, @PathVariable String roleName) {
		//Testing
		//EmployeePayroll empPayroll = new EmployeePayroll(1L, 1L, "Test", "Last", 1L, "TST", "Test Engineer");
		//Using Rest Template
//		ResponseEntity<EmployeePayroll> employee = new RestTemplate().getForEntity("http://localhost:8100/employee/{empId}", EmployeePayroll.class, empId);
		EmployeePayroll employeePayroll = employeeService.getEmployee(empId).getBody();
		System.out.println("["+this.getClass().getName()+"][insertEmployeePayrollDetails] employee with id [" + empId + "]: "+employeePayroll);
		//ResponseEntity<EmployeePayroll> employeeRole = new RestTemplate().getForEntity("http://localhost:8101/role/{roleName}", EmployeePayroll.class, roleName);
		ResponseEntity<EmployeePayroll> employeeRole = roleService.getRoleByRoleName(roleName);
		System.out.println("["+this.getClass().getName()+"][insertEmployeePayrollDetails] role with name [" + roleName + "]: "+employeeRole.getBody());
		
				
		
		//Using Feign Client
		
		
		employeePayroll.setRoleId(employeeRole.getBody().getRoleId());
		employeePayroll.setRoleName(employeeRole.getBody().getRoleName());
		employeePayroll.setDescription(employeeRole.getBody().getDescription());
		
		empPayrollRepository.saveAndFlush(employeePayroll);
	}
	
	@GetMapping("/employee/payroll")
	public ResponseEntity<List<EmployeePayroll>> getEmployeePayroll() {
		return new ResponseEntity<List<EmployeePayroll>>(empPayrollRepository.findAll(), HttpStatus.OK);
	}
	
	
}
