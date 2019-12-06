package food;

import org.springframework.beans.factory.annotation.Autowired;

public class Meal {
	@Autowired
	private Vegetable vegetable;
	@Autowired
	private Fruit fruit;
	@Autowired(required = false)
	private Meat meat;
	@Autowired
	private Milk milk;
	@Autowired
	private Grain grain;
	
	public Meal() {}
	
	//Auto wiring using constructors
	//@Autowired
	public Meal(Vegetable vegetable, Fruit fruit, Meat meat, Milk milk, Grain grain) {
		this.vegetable=vegetable;
		this.fruit=fruit;
		this.meat=meat;
		this.milk=milk;
		this.grain=grain;
	}
	
	
	
	public Vegetable getVegetable() {
		return vegetable;
	}


	
	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}



	public Fruit getFruit() {
		return fruit;
	}


	
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}



	public Meat getMeat() {
		return meat;
	}


	
	public void setMeat(Meat meat) {
		this.meat = meat;
	}



	public Milk getMilk() {
		return milk;
	}


	
	public void setMilk(Milk milk) {
		this.milk = milk;
	}



	public Grain getGrain() {
		return grain;
	}


	
	public void setGrain(Grain grain) {
		this.grain = grain;
	}



	public String whatsInMeal() {
		String feed = "This meal contains: \n";
		if(vegetable!=null)
			feed += vegetable.talkAboutYourself();
		if(fruit!=null)
			feed += fruit.talkAboutYourself();
		if(meat!=null)
			feed += meat.talkAboutYourself();
		if(milk!=null)
			feed += milk.talkAboutYourself();
		if(grain!=null)
			feed += grain.talkAboutYourself();
		return feed;
	}

}
