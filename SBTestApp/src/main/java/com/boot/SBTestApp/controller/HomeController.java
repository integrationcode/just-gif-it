package com.boot.SBTestApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/")
public class HomeController {

	//@RequestMapping(path = "students", method = RequestMethod.GET )
	@GetMapping
	public String getCall() {
		return "Spring Boot is Ready";
	}
}
