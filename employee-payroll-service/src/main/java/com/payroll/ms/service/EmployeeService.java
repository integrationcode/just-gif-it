package com.payroll.ms.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.payroll.ms.model.EmployeePayroll;

//@FeignClient(name = "employee-service", url = "localhost:8100")
@FeignClient(name = "employee-service") //With ribbon don't need the url, as there could be multiple instance of the service running
@RibbonClient(name = "employee-service")
public interface EmployeeService {
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<EmployeePayroll> getEmployee(@PathVariable("empId") Long empId);
}
