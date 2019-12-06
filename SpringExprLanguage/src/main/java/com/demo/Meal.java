package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Meal {
	
	@Value("#{myDemoFruit}")
	private Fruit fruit;

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	
	public String getDescription() {
		String desc = "";
		if(fruit != null)
			desc += fruit.talkAboutYourself();
		
		return desc;
	}
}
