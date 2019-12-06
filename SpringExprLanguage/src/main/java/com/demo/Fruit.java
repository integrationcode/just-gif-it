package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Fruit {
	private String name;
	private int nutritionalRating;
	public String getName() {
		return name;
	}
	
	//Example of spring expression language using static and non-static member access
	@Autowired
	//public void setName(@Value("#{demoDataSource.getApplyType() + ' Apple'}") String name) {
	public void setName(@Value("#{T(com.demo.DataSource).getAppleTypeStatic() + ' Apple'}") String name) {
		this.name = name;
	}
	public int getNutritionalRating() {
		return nutritionalRating;
	}
	//Example of spring expression language
	//? is a safe navigation operation, which helps to handle null
	@Autowired
	public void setNutritionalRating(@Value("#{T(java.lang.Math).random() * 10 + demoDataSource.getApplyType()?.length()}") int nutritionalRating) {
		this.nutritionalRating = nutritionalRating;
	}
	
	public Fruit() {}
	
	public String talkAboutYourself() {
		String feed = "";
		if(name!=null)
			feed += "Name is: " + name + "\n";
		if(nutritionalRating>0)
			feed += "Nutritional Rating is: " + nutritionalRating + "\n";
		
		if(feed=="")
			feed = "Not Set!";
		
		return feed;
	}
}
