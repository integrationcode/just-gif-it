DROP TABLE IF EXISTS EMPLOYEE;
CREATE TABLE IF NOT EXISTS EMPLOYEE (
	EMP_ID INT AUTO_INCREMENT, 
	FIRST_NAME VARCHAR(255), 
	LAST_NAME VARCHAR(2000), 
	DATE_OF_JOINING DATE
);

insert into employee (first_name, last_name, date_of_joining) values ('A First','A Last', sysdate());
insert into employee (first_name, last_name, date_of_joining) values ('B First','B Last', sysdate());
insert into employee (first_name, last_name, date_of_joining) values ('C First','C Last', sysdate());