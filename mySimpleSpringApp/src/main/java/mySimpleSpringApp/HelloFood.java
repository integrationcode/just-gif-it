package mySimpleSpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloFood {

	public static void main(String[] args) {
		/*
		 * Fruit f = new Fruit(); Vegetable v = new Vegetable();
		 */
		
		//ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("myConfigs/appContext.xml");
		Fruit f = (Fruit) appContext.getBean("fruit");		
		Vegetable v = (Vegetable) appContext.getBean("vegetable");
		
		System.out.println(f.talkAboutYourself());
		System.out.println(v.talkAboutYourself());
		
		Fruit fWithName = (Fruit) appContext.getBean("furitWithName", Fruit.class);
		System.out.println("Fruit with name: " + fWithName.talkAboutYourself());
		Vegetable vWithName = appContext.getBean("vegWithName", Vegetable.class);
		System.out.println("Vegetbale with name: " + vWithName.talkAboutYourself());
		
		Fruit fWithNameAndList = appContext.getBean("fruitWithNameAndList", Fruit.class);
		System.out.println("Fruit with List: " + fWithNameAndList.talkAboutYourself());
		
		Vegetable vegWithPName = appContext.getBean("vegWithPName", Vegetable.class);
		System.out.println("Vegetable With PName: "+vegWithPName.talkAboutYourself());
		
		//Spring Bean with Setter Injector
		System.out.println("Spring Bean with Injector");
		
		Meal meal = new Meal();
		System.out.println(meal);
		
		Meal springMeal = appContext.getBean("meal", Meal.class);
		System.out.println(springMeal);
		
		Meal springMealWithConst = appContext.getBean("mealWithConstInjection",Meal.class);
		System.out.println(springMealWithConst);
		System.out.println(springMealWithConst.getFruit().talkAboutYourself());
		
		
		//Bean with properties
		Fruit fp = appContext.getBean("fruitWithProperty", Fruit.class);
		System.out.println("[With Properites] Fruit: " + fp.talkAboutYourself());
		Vegetable vp = appContext.getBean("vegetableWithProperty", Vegetable.class);
		System.out.println("[With Properites] Vegetable: " + vp.talkAboutYourself());
		
		//Nested bean with properties
		Meal nestedMeal = appContext.getBean("mealWithNestedAndProperties", Meal.class);
		System.out.println("[Nested Meal] " + nestedMeal.whatsInMyMeal());
		
		//Autowiring Meal
		Meal autoWiringMeal = appContext.getBean("autoWiringByTypeMeal", Meal.class);
		System.out.println("[AutoWiring Meal]"+autoWiringMeal.whatsInMyMeal());
		
		((ClassPathXmlApplicationContext) appContext).close();

	}

}
