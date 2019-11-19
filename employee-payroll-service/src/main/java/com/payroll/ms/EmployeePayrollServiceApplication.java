package com.payroll.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.payroll.ms") //Scans the given package to check for feign clients
public class EmployeePayrollServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollServiceApplication.class, args);
	}

}
