package com.payroll.ms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.ms.model.EmployeeRole;

@Repository(value = "EmpRoleRepo")
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Long> {
	public EmployeeRole findByRoleName(String roleName);

}
