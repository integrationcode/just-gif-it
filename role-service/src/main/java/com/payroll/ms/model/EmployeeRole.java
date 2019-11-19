package com.payroll.ms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeRole {
	
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	private String description;
	
	public EmployeeRole() {
		System.out.println("["+this.getClass().getName()+"][Default Constructor]");
	}
	
	public EmployeeRole(Long roleId, String roleName, String description) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		System.out.println("["+this.getClass().getName()+"][Parameterized Constructor]");
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EmployeeRole [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description + "]";
	}
	
}
