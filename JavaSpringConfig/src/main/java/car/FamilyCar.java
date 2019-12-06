package car;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

//@Component(value = "familyCar")
public class FamilyCar {

	//Using reflection
	@Autowired
	@Qualifier(value = "smallTyre")
	private Tyre frontLeft;
	@Inject
	@Named(value = "smallTyre")
	private Tyre frontRight;
	
	private Tyre rearLeft;
	
	private Tyre rearRight;
	
	private Engine engineType;

	public Tyre getFrontLeft() {
		return frontLeft;
	}

	public void setFrontLeft(Tyre frontLeft) {
		this.frontLeft = frontLeft;
	}

	public Tyre getFrontRight() {
		return frontRight;
	}

	public void setFrontRight(Tyre frontRight) {
		this.frontRight = frontRight;
	}

	public Tyre getRearLeft() {
		return rearLeft;
	}

	@Autowired
	@Qualifier(value = "bigTyre")
	public void setRearLeft(Tyre rearLeft) {
		System.out.println("Setting Rear Left Tyre using injection");
		this.rearLeft = rearLeft;
	}

	public Tyre getRearRight() {
		return rearRight;
	}

	//Using setter injection
	@Autowired
	@Qualifier(value = "bigTyre")
	public void setRearRight(Tyre rearRight) {
		System.out.println("Setting Rear Right Tyre using injection");
		this.rearRight = rearRight;
	}

	public Engine getEngineType() {
		return engineType;
	}

	@Autowired
	@Qualifier(value = "sixCyl")
	public void setEngineType(Engine engineType) {
		System.out.println("Setting Engine using injection");
		this.engineType = engineType;
	}
	
	public FamilyCar() {}
	
	public FamilyCar(Tyre frontLeft, Tyre frontRight, Tyre rearLeft, Tyre rearRight, Engine engineType) {
		this.frontLeft=frontLeft;
		this.frontRight=frontRight;
		this.rearLeft=rearLeft;
		this.rearRight=rearRight;
		this.engineType=engineType;
	}
	
	
	public String getCarDescription() {
		String description = "";
		
		if(frontLeft!=null)
			description = description + " Front Left Tyre: " + frontLeft.getTyreDiameter();
		if(frontRight!=null)
			description = description + " Front Right Tyre: " + frontRight.getTyreDiameter();
		if(rearLeft!=null)
			description = description + " Rear Left Tyre: " + rearLeft.getTyreDiameter();
		if(rearRight!=null)
			description = description + " Rear Right Tyre: " + rearRight.getTyreDiameter();
		if(engineType!=null)
			description = description + " Engine Type: " + engineType.getNumberOfCylinders();
		
		if(description=="")
			description = "Not Set!";
		
		return description;
	}
	
	

}
