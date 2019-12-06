package car;

import org.springframework.stereotype.Component;

@Component("bigTyre")
public class BigTyre implements Tyre {

	public String getTyreDiameter() {
		return "Diameter is 16 inches";
	}

}
