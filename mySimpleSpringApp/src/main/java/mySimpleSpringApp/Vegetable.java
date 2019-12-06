package mySimpleSpringApp;

public class Vegetable {
	private String myName;
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String talkAboutYourself() {
		String feed = "I am Vegetable. I am a plant that is eaten as food.";
		
		//feed = feed + ". My name is: " + getMyName();
		return (myName != null && !myName.equals(""))?(feed+". My name is: " + getMyName()):feed;
	}
}
