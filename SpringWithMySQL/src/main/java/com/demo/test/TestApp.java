package com.demo.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.demo.model.FoodGroup;
import com.demo.model.FoodGroupDAO;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/demo/config/appContext.xml");
		
		try {
			
			/*
			 * List<FoodGroup> foodGroups = new ArrayList<FoodGroup>(); foodGroups.add(new
			 * FoodGroup("nine", "nine test")); foodGroups.add(new FoodGroup("ten",
			 * "ten test")); foodGroups.add(new FoodGroup("eleven", "eleven test"));
			 * foodGroups.add(new FoodGroup("nine", "twelve test"));
			 */
			
			
			
			FoodGroupDAO fgDAO = appContext.getBean("foodGroupDAO", FoodGroupDAO.class);
			
			/*
			 * int [] insertedIds = fgDAO.batchUpdate(foodGroups); for(int id : insertedIds)
			 * System.out.println("Inserted ID: " + id);
			 */
			//fgDAO.simpleInsert(new FoodGroup("Water2","Used for drinking!"));
			System.out.println("SP Call: "+fgDAO.readFoodGroup(23));
			//fgDAO.update(new FoodGroup(8,"Test2","Testing update 2!"));
			System.out.println(fgDAO.getFoodGroups().toString());
			fgDAO.demoMethod();
			//System.out.println(fgDAO.getFoodGroupsBasedOnWhere("Vegetable"));
			//System.out.println(fgDAO.getFoodGroupById(4));
			//fgDAO.delete(8);
			//System.out.println(fgDAO.getFoodGroups().toString());
			
			//fgDAO.addFoodGroups("Demo", "Not a real food group");
			
			//fgDAO.addFoodGroups(new FoodGroup("Iron", "Non Edible" ));
			//fgDAO.createFoodGroups();
		}catch(DataAccessException e) {
			System.out.println("["+e.getClass()+"]"+e.getMessage());
			
		}
		((ClassPathXmlApplicationContext) appContext).close();

	}

}
