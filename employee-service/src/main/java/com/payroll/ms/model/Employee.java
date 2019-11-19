package com.payroll.ms.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name = "date_of_joining")
	private Date dateOfJoining;
	
	public Employee() {
		//System.out.println("["+this.getClass().getName()+"]");
		System.out.println("["+this.getClass().getName()+"] default constructor.");
	}
	
	public Employee(String firstName, String lastName, Long empId, Date dateOfJoining) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
		this.dateOfJoining = dateOfJoining;
		System.out.println("["+this.getClass().getName()+"] paramterized constructor");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", empId=" + empId + ", dateOfJoining="
				+ dateOfJoining + "]";
	}
	
	
}
