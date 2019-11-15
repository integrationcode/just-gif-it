package com.payroll.ms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.payroll.ms.model.EmployeePayroll;

@FeignClient(name = "employee-service", url = "localhost:8100")
public interface EmployeeService {
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<EmployeePayroll> getEmployee(@PathVariable("empId") Long empId);
}
