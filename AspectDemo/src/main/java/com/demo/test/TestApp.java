package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.config.AppConfig;
import com.demo.sportEquipment.GolfClub;
import com.demo.vehicle.Car;
import com.demo.vehicle.Coupe;
import com.demo.vehicle.offroad.DirtBike;
import com.demo.vehicle.offroad.FourWheeler;

public class TestApp {

	public static void main(String[] args) {
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("com/demo/config/appConfig.xml");
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Car car = appContext.getBean("car", Car.class);
		FourWheeler fourWheeler = appContext.getBean("myFourWheeler", FourWheeler.class);
		DirtBike dirtBike = appContext.getBean("myDirtBike", DirtBike.class);
		GolfClub golfClub = appContext.getBean("golfClub", GolfClub.class);
		Coupe myCoupe = appContext.getBean("myCoupe", Coupe.class);
		
		try {
			car.drive();
			System.out.println("[TestApp] Car with echo: " +car.drive(88,true, "Enjoy the view!"));
			car.drive(125.30f);
			System.out.println("[TestApp] Car is being driven at: "+car.drive(20.5f, 78.3f));
			car.drift();
			car.stop();
			
			fourWheeler.drive();
			fourWheeler.stop();
			
			dirtBike.drive(53.4f);
			dirtBike.stop();
			
			golfClub.drive();
			golfClub.swing();
			
			myCoupe.drive();
		
		
		}catch(Exception e) {
			System.out.println("[TestApp] Exception: "+e.getMessage());
		}
		((AnnotationConfigApplicationContext) appContext).close();

	}

}
