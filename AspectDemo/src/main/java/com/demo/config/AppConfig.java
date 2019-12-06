package com.demo.config;

//import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.demo.sportEquipment.GolfClub;
import com.demo.vehicle.Car;
import com.demo.vehicle.offroad.DirtBike;
import com.demo.vehicle.offroad.FourWheeler;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.demo.aspect","com.demo.vehicle"})
public class AppConfig {
	
	@Bean(name = "car")
	public Car getVar() {
		return new Car();
	}

//	@Bean(name="fourWheeler")
//	public FourWheeler getFourWheeler() {
//		return new FourWheeler();
//	}
	
	@Bean(name="myDirtBike")
	public DirtBike getDirtBike() {
		return new DirtBike();
	}
	
	@Bean(name = "golfClub")
	public GolfClub getGolfClub() {
		return new GolfClub();
	}
}
