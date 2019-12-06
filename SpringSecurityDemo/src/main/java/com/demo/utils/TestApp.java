package com.demo.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class TestApp {

	public static void main(String[] args) {
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("com/demo/config/appConfig.xml");
		
		
		//PasswordDemo pd = appContext.getBean("passwordDemo", PasswordDemo.class);
		PasswordDemo pd = new PasswordDemo();
		pd.getMD5Hash("manage");
		pd.getBCryptHash("manage");
		NamedParameterJdbcTemplate myNamedParamJdbcTemplate;
		

	}

}
