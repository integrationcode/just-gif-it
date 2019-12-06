package mySimpleSpringApp;

public class Meat {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String talkAboutYourself() {
		String feed = "I am Meat. I come from animals.";
		return feed;
	}
}
