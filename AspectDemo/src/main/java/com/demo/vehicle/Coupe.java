package com.demo.vehicle;

import org.springframework.stereotype.Component;

import com.demo.aspect.RandomDemoAnnotation;

@Component("myCoupe")
@RandomDemoAnnotation
public class Coupe {

	public void drive() {
		System.out.println("[Coupe] Two door car, I am driving! ");
	}
}
