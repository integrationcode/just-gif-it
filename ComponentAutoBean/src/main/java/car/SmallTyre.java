package car;

import org.springframework.stereotype.Component;

public class SmallTyre implements Tyre {

	public String getTyreDiameter() {
		return "Diameter is 14 inches";
	}

}
