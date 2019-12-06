package mySimpleSpringApp;

public class Apple extends Fruit {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apple(String name, String description) {
		super(name);
		this.description=description;
	}
	
	public String talkAboutYourself() {
		String feed = super.talkAboutYourself();
		if(description!=null && description.length()>0)
			feed = feed + ". " + description;
		return feed;
	} 
	
	
}
