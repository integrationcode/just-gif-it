package car;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Component(value = "familyCar")
public class FamilyCar {
	//Spring Native Annotation
	//@Autowired
	//@Qualifier(value = "smallType")
	//Java JSR-250 Annotation
	//@Resource(name = "smallTyre")
	//Java JSR-330 Annotation
	@Inject
	@Named(value = "smallTyre")
	private Tyre frontLeft;
	//@Autowired
	//@Qualifier(value = "smallType")
	//@Resource(name = "smallTyre")
	@Inject
	@Named(value = "smallTyre")
	private Tyre frontRight;
	//@Autowired
	//@Qualifier(value = "bigType")
	//@Resource(name = "bigTyre")
	@Inject
	@Named(value = "bigTyre")
	private Tyre rearLeft;
	//@Autowired
	//@Qualifier(value = "bigType")
	//@Resource(name = "bigTyre")
	@Inject
	@Named(value = "bigTyre")
	private Tyre rearRight;
	//@Autowired
	//@Qualifier(value = "fourCyl")
	//@Resource(name = "sixCyl")
	@Inject
	@Named("fourCyl")
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

	public void setRearLeft(Tyre rearLeft) {
		this.rearLeft = rearLeft;
	}

	public Tyre getRearRight() {
		return rearRight;
	}

	public void setRearRight(Tyre rearRight) {
		this.rearRight = rearRight;
	}

	public Engine getEngineType() {
		return engineType;
	}

	public void setEngineType(Engine engineType) {
		this.engineType = engineType;
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
