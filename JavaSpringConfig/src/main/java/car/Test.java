package car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;

public class Test {

	public static void main(String[] args) {
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("config/appContext.xml");
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		SixCylinderEngine sixCylEngine = appContext.getBean("sixCyl", SixCylinderEngine.class);
		System.out.println(sixCylEngine.getNumberOfCylinders());
		
		FourCylinderEngine fourCyl = appContext.getBean("fourCyl",FourCylinderEngine.class);
		System.out.println(fourCyl.getNumberOfCylinders());
		
		FamilyCar familyCar = appContext.getBean("familyCar", FamilyCar.class);
		System.out.println(familyCar.getCarDescription());
		
		((AnnotationConfigApplicationContext) appContext).close();
	}

}
