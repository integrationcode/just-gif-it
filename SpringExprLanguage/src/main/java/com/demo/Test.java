package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/appContext.xml");
		Fruit fruit = appContext.getBean("fruit", Fruit.class);
		System.out.println("[Fruit] "+fruit.talkAboutYourself());
		
		Meal meal = appContext.getBean(Meal.class);
		System.out.println(meal.getDescription());
		((ClassPathXmlApplicationContext) appContext).close();

	}

}
