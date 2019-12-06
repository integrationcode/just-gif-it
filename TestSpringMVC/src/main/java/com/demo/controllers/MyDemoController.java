package com.demo.controllers;

import java.io.FileOutputStream;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Account;

@Controller
@SessionAttributes("aNewAccount")
public class MyDemoController {
	Account account = new Account();

	//http://localhost:8080/TestSpringMVC/getQuotes.html
	private String[] quotes = {"first","second","third","fourth","fifth"};


	//Works only if URL doesn't have 'from' parameter
	//@RequestMapping(value = "/getQuote", params = "!from")
	//Works only if URL has specific 'from'
	//@RequestMapping(value = "/getQuote", params = "from=Manoj")
	//Works only if URL has 'from' parameter
	@RequestMapping(value = "/getQuote", params = "from")

	//Works with both request parameter and headers
	//@RequestMapping(value = "/getQuote", params = "from", headers = "X-API-KEY")
	public String getRandomQuote(Model model) {
		System.out.println("URL mapped correctly!");
		int rand = new Random().nextInt(quotes.length);

		model.addAttribute("randomQuote", quotes[rand]);
		System.out.println("Model updated with random quote!");
		return "quote";
	}

	//Will be invoked before any other handler method	
	//	  @ModelAttribute public void setUserDetails(@RequestParam("from") String userName, Model model) { 
	//		  model.addAttribute("userName",userName); 
	//		  String userRole = "undefined"; 
	//		  if(userName.equals("Manoj")) { 
	//			  userRole="Student";
	//		  }else if(userName.equals("Mishika")) { 
	//			  userRole="Administrator"; 
	//		  }
	//	  model.addAttribute("userRole", userRole);
	//	  
	//	  System.out.println("Model is updated with user information!"); 
	//	 }




	@ModelAttribute public void addAccountToModel(Model model) {
		System.out.println("Making sure account boject is added to model.");
		if(!model.containsAttribute("aNewAccount")) {
			System.out.println("Account doesn't exist!"); Account acc = new Account();
			model.addAttribute("aNewAccount", acc); 
		} 
	}

	@RequestMapping(value="/createAccount")
	public String createAccount(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result) {

		if(result.hasErrors()) {
			System.out.println("Form has errors. " + result.getAllErrors().toString());
			return "createAccount";
		}

		System.out.println("Form Validated!");
		System.out.println("[Create Account] Account Details: First Name: " + account.getFirstName() + "; Last Name: "+account.getLastName()+ "; Age: "+account.getAge()+"; Address: "+ account.getAddress()+ "; Email: "+account.getEmail());
		return "createAccount";
	}

	@RequestMapping(value="/doCreate", method = RequestMethod.POST)
	public String createAccount(@ModelAttribute("aNewAccount") Account account) {

		System.out.println("[Do Create] Account Details: First Name: " + account.getFirstName() + "; Last Name: "+account.getLastName()+"; Address: "+ account.getAddress()+ "; Email: "+account.getEmail());
		return "redirect:accConfirm";
	}

	@RequestMapping(value="/accConfirm")
	public String confAccount(@ModelAttribute("aNewAccount") Account account) {

		System.out.println("[Acc Confirm] Account Details: First Name: " + account.getFirstName() + "; Last Name: "+account.getLastName()+"; Address: "+ account.getAddress()+ "; Email: "+account.getEmail());
		return "accountCreated";
	}


	//Handler for file upload functionality
	@RequestMapping(value = "/myForm")
	public String myForm() {
		return "myForm";
	}

	//Handler for file upload functionality
	@RequestMapping(value = "/handleForm")
	public String handleForm(@RequestParam("file") MultipartFile file) {		
		try {
			if(!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				FileOutputStream fos = new FileOutputStream("D:\\temp\\"+file.getName());
				fos.write(bytes);
				fos.close();
				System.out.println("File written successfully at: D:\\temp\\"+file.getName());
			}else {
				System.out.println("No file available to save.");
			}

		}catch (Exception e) {
			System.out.println("Error saving file. "+e.getMessage());
		}
		return "operationCompleted";
	}

	@RequestMapping(value = "/addCookie")
	public String addCookie(HttpServletResponse response) {
		response.addCookie(new Cookie("myRandomCookie", "aCookieIAdded"));
		System.out.println("Cookie Added!");
		return "demoPage";
	}

	@RequestMapping(value = "/getCookie")
	public String getCookie(@CookieValue("myRandomCookie") String myCookie) {
		System.out.println("Cookie Retrieved: " + myCookie);
		return "demoPage";
	}
}
