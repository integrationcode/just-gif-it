package mySimpleSpringApp;

import java.util.List;
import java.util.Map;

public class Fruit {
	private String name;
	private List<String> fruitNameList;
	private Map<String, String> fruitNameMap;
	
	public Fruit() {}
	
	public Fruit(String name) {
		this.name=name;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<String> getFruitNameList() {
		return fruitNameList;
	}

	public void setFruitNameList(List<String> fruitNameList) {
		this.fruitNameList = fruitNameList;
	}

	public Map<String, String> getFruitNameMap() {
		return fruitNameMap;
	}

	public void setFruitNameMap(Map<String, String> fruitNameMap) {
		this.fruitNameMap = fruitNameMap;
	}

	public String talkAboutYourself() {
		String feed = "I am Fruit. I come from plants or tree with seeds";
		feed = (name != null && !name.equals(""))?(feed+". My name is: " + name):feed;
		
		if(fruitNameList != null && fruitNameList.size() >0) {
			feed = feed + "\n Fruit List: " + fruitNameList.toString();
		}
		
		if(fruitNameMap != null && fruitNameMap.size() >0) {
			feed = feed + "\n Fruit Map: " + fruitNameMap.toString();
		}
		return feed;
	}
	
	public void initMethod() {
		System.out.println("Initialized!");
	}
	
	public void destroyMethod() {
		System.out.println("Destroyed!");
	}
}
