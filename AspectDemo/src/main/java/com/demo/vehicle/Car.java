package com.demo.vehicle;

import com.demo.aspect.RandomDemoAnnotation;

public class Car {

	@RandomDemoAnnotation
	public void drive() {
		System.out.println("[Car] I am driving.");
	}
	
	public float drive(float speed) {
		System.out.println("[Car] Acclerating and driving at a speed of " + speed + " Km/hr.");
		return speed;
	}
	
	public float drive(float fromSpeed, float toSpeed) {
		System.out.println("[Car] Driving between " + fromSpeed + " Km/hr to " + toSpeed + " Km/hr.");
		return ((fromSpeed+toSpeed)/2);
	}
	
	public void drift() {
		System.out.println("[Car] We are about to drift!");
	}
	
	public String stop() {
		System.out.println("[Car] Deaccelerating and applying break!");
		return "[Car] Red light time to stop!";
	}
	
	public String drive(int speed, boolean canDrive, String shoutOutOfWindow) throws Exception {
		if(canDrive) {
			System.out.println("[Car] I am driving at a speed of " + speed +" Km/hr.");
			shoutOutOfWindow += " Driving!";
		}else {
			System.out.println("[Car] Need gas to drive.");
			throw new RuntimeException("NO_GAS_TO_DRIVE");
		}
		
		return shoutOutOfWindow;
	}
}
