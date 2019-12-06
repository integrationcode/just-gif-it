package com.demo.vehicle.offroad;

import org.springframework.stereotype.Component;

@Component("myFourWheeler")
public class FourWheeler {
	public void drive() {
		System.out.println("[FourWheeler] I am driving \n");
	}
	
	public void stop() {
		System.out.println("[FourWheeler] Slowing to stop! \n");
	}
}
