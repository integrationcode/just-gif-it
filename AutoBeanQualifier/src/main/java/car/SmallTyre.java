package car;

import org.springframework.stereotype.Component;

@Component("smallTyre")
public class SmallTyre implements Tyre {

	public String getTyreDiameter() {
		return "Diameter is 14 inches";
	}

}
