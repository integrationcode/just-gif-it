package food;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/appContext.xml");
		
		System.out.println(appContext.getBean("fruit", Fruit.class).talkAboutYourself());
		System.out.println(appContext.getBean("anotherFruit", Fruit.class).talkAboutYourself());
		
		System.out.println(appContext.getBean("meal", Meal.class).whatsInMeal());
		
		
		((ClassPathXmlApplicationContext) appContext).close();
	}

}
