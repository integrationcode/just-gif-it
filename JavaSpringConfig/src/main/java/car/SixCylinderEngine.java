package car;

import org.springframework.stereotype.Component;


public class SixCylinderEngine implements Engine {

	public int getNumberOfCylinders() {
		
		return 6;
	}

	public String drive() {
		
		return "This car runs on 6 cylinders";
	}

}
