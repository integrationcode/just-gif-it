package com.payroll.ms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.payroll.ms.model.EmployeePayroll;


@FeignClient(name = "role-service", url = "localhost:8101")
public interface RoleService {

	@GetMapping(path = "/role/{roleName}")
	public ResponseEntity<EmployeePayroll> getRoleByRoleName(@PathVariable("roleName") String roleName);
}
