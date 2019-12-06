package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("Login handler runnging!");
		model.addAttribute("customLoginAttribute", "Coming from Login Controller");
		return "login";
		
	}
	
	
	@RequestMapping(value = "/loginFail", method = RequestMethod.GET)
	public String loginFail(Model model) {
		System.out.println("Login fail handler runnging!");
		model.addAttribute("loginError", "Login failed! Please check credentials.");
		return "login";
		
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		System.out.println("Logout handler running!");
		model.addAttribute("logoutMessage", "Thanks for using the app. See you next time!");
		return "logout";
	}
}
