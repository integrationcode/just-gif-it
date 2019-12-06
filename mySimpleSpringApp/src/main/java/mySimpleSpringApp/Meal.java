package mySimpleSpringApp;

public class Meal {
	private Fruit fruit;
	private Vegetable vegetable;
	private Meat meat;
	private Dairy dairy;
	private Grain grain;
	
	public Meal() {}
	
	
	
	public Meal(Fruit fruit, Vegetable vegetable, Meat meat, Dairy dairy, Grain grain) {
		super();
		this.fruit = fruit;
		this.vegetable = vegetable;
		this.meat = meat;
		this.dairy = dairy;
		this.grain = grain;
	}



	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	public Vegetable getVegetable() {
		return vegetable;
	}
	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}
	public Meat getMeat() {
		return meat;
	}
	public void setMeat(Meat meat) {
		this.meat = meat;
	}
	public Dairy getDairy() {
		return dairy;
	}
	public void setDairy(Dairy dairy) {
		this.dairy = dairy;
	}
	public Grain getGrain() {
		return grain;
	}
	public void setGrain(Grain grain) {
		this.grain = grain;
	}
	public String toString() {
		String message = "My meal has:";
		if(fruit!=null)
			message = message + " some fruits.";
		if(vegetable!=null)
			message = message + " some vegetables.";
		if(meat!=null)
			message = message + " some meat.";
		if(dairy!=null)
			message = message + " some dairy.";
		if(grain!=null)
			message = message + " some grains.";
		return message;
	}
	
	public String whatsInMyMeal() {
		String message = "My meal has:";
		if(fruit!=null)
			message = message + fruit.talkAboutYourself();
		if(vegetable!=null)
			message = message + vegetable.talkAboutYourself();
		if(meat!=null)
			message = message + meat.talkAboutYourself();
		if(dairy!=null)
			message = message + dairy.talkAboutYourself();
		if(grain!=null)
			message = message + grain.talkAboutYourself();
		return message;
	}
}
