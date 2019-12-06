package car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/appContext.xml");
		FamilyCar familyCar = appContext.getBean("familyCar", FamilyCar.class);
		//System.out.println(familyCar.getFrontRight().getTyreDiameter());
		System.out.println(familyCar.getCarDescription());
		
		((ClassPathXmlApplicationContext) appContext).close();
	}

}
