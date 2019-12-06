package mySimpleSpringApp;

public class Grain {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String talkAboutYourself() {
		String feed = "I am Grain. I come from roots.";
		feed = (name != null && !name.equals(""))?(feed+". My name is: " + name):feed;
		return feed;
	}
}
