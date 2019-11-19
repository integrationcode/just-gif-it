package com.payroll.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.ms.model.Employee;

@Repository("EmpRepo")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
