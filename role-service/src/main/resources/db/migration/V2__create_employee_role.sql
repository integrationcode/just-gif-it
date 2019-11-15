DROP TABLE IF EXISTS EMPLOYEE;
CREATE TABLE IF NOT EXISTS EMPLOYEE_ROLE (
	ROLE_ID INT AUTO_INCREMENT, 
	ROLE_NAME VARCHAR(255), 
	DESCRIPTION VARCHAR(2000)
);

insert into employee_role (role_name, description) values ('HR','Human Resources');
insert into employee_role (role_name, description) values ('ADM','Administrator');
insert into employee_role (role_name, description) values ('SM','Senior Manager');