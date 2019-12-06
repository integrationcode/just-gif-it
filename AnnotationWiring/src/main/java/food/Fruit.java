package food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;

public class Fruit {
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	@Autowired
	public void setDescription(@Value("This desription is coming from value annotation!") String description) {
		this.description = description;
	}

	public String talkAboutYourself() {
		String feed = "I am fruit. I come from plants and seeds! \n";
		if(name!=null)
			feed = feed + " Name: " + name +" \n";
		if(description!=null)
			feed = feed + " Description: " + description +" \n";
		return feed;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("Fruit bean is ready to be used. " + this.description);
	}
	@PreDestroy
	public void destroyMethod() {
		System.out.println("Fruit bean is about to be destroyed!");
	}
}

