package com.demo;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component("demoDataSource")
public class DataSource {
	public String appleDescription = "Hi, I am an apple description!";
	
	public static String getAppleTypeStatic() {
		ArrayList<String> types = new ArrayList<String>();
		types.add("State Fair");
		types.add("McIntosh");
		types.add("Honeycrisp");
		types.add("Regent");
		types.add("Pinata");
		types.add("Granny Smith");
		
		int index = new Random().nextInt(types.size());
		String type = types.get(index);
		return null;
	}
	
	public String getApplyType() {
		ArrayList<String> types = new ArrayList<String>();
		types.add("State Fair");
		types.add("McIntosh");
		types.add("Honeycrisp");
		types.add("Regent");
		types.add("Pinata");
		types.add("Granny Smith");
		
		int index = new Random().nextInt(types.size());
		String type = types.get(index);
		return type;

	}
}
