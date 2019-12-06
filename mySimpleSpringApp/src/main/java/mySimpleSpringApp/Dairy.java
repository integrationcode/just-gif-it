package mySimpleSpringApp;

public class Dairy {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String talkAboutYourself() {
		String feed = "I am Dairy. I come from milk products.";		
		return feed;
	}
}
