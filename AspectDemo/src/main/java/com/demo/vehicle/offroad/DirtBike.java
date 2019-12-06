package com.demo.vehicle.offroad;

import com.demo.aspect.RandomDemoAnnotation;

public class DirtBike {
	@RandomDemoAnnotation
	public void drive(float speed) {
		System.out.println("[DirtBike] I am driving at a speed of " + speed + " Km/hr. \n");
	}
	
	public void stop() {
		System.out.println("[DirtBike] Slowing to stop! \n");
	}
}
