package com.payroll.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.payroll.ms.model.EmployeePayroll;
import com.payroll.ms.repository.EmployeePayrollRepository;

@RestController
public class EmployeePayrollController {

	@Autowired
	private EmployeePayrollRepository empPayrollRepository;
	
	
	@PostMapping("/employee/{empId}/role/{roleName}")
	public void insertEmployeePayrollDetails(@PathVariable Long empId, @PathVariable String roleName) {
		//EmployeePayroll empPayroll = new EmployeePayroll(1L, 1L, "Test", "Last", 1L, "TST", "Test Engineer");
		ResponseEntity<EmployeePayroll> employee = new RestTemplate().getForEntity("http://localhost:8100/employee/{empId}", EmployeePayroll.class, empId);
		System.out.println("["+this.getClass().getName()+"][insertEmployeePayrollDetails] employee with id [" + empId + "]: "+employee.getBody());
		ResponseEntity<EmployeePayroll> employeeRole = new RestTemplate().getForEntity("http://localhost:8101/role/{roleName}", EmployeePayroll.class, roleName);
		System.out.println("["+this.getClass().getName()+"][insertEmployeePayrollDetails] role with name [" + roleName + "]: "+employeeRole.getBody());
		
		EmployeePayroll employeePayroll = employee.getBody();
		employeePayroll.setRoleId(employeeRole.getBody().getRoleId());
		employeePayroll.setRoleName(employeeRole.getBody().getRoleName());
		employeePayroll.setDescription(employeeRole.getBody().getDescription());
		
		empPayrollRepository.saveAndFlush(employeePayroll);
	}
}
