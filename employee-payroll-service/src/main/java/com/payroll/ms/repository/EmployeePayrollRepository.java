package com.payroll.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.ms.model.EmployeePayroll;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Long> {

}
