package car;

import org.springframework.stereotype.Component;

@Component("fourCyl")
public class FourCylinderEngine implements Engine {

	public int getNumberOfCylinders() {		
		return 4;
	}

	public String drive() {		
		return "This car runs on 4 cylinder";
	}

}
