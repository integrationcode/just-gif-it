package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import car.BigTyre;
import car.Engine;
import car.FamilyCar;
import car.FourCylinderEngine;
import car.SixCylinderEngine;
import car.SmallTyre;
import car.Tyre;

@Configuration
@ComponentScan({"car"})
public class AppConfig {

//	@Bean(name = "fourCyl")
//	public Engine getFourCylEngine() {
//		return new FourCylinderEngine();
//	}


	@Bean(name = "sixCyl") 
	public Engine getSixCylEngine() { 
		return new SixCylinderEngine(); 
	}

	@Bean(name = "smallTyre") 
	public Tyre getSmallTyre() { 
		return new SmallTyre(); 
	}


	@Bean(name = "bigTyre")
	public Tyre getBigTyre() {
		return new BigTyre();
	}

	@Bean(name = "familyCar")
	public FamilyCar getFamilyCar() {
		//FamilyCar fCar = new FamilyCar(getSmallTyre(),getSmallTyre(),getBigTyre(),getBigTyre(),getFourCylEngine());
		FamilyCar fCar = new FamilyCar();
		//fCar.setEngineType(getFourCylEngine());
		return fCar;
	}
}
