package car;

import org.springframework.stereotype.Component;


public class BigTyre implements Tyre {

	public String getTyreDiameter() {
		return "Diameter is 20 inches";
	}

}
