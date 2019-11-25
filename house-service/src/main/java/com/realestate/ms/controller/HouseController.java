package com.realestate.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.ms.config.HouseConfig;
import com.realestate.ms.model.House;

@RestController
public class HouseController {
	
	@Autowired
	private HouseConfig houseConfig;
	
	@GetMapping(path = "/house/")
	public ResponseEntity<House> getHouse(){
		return new ResponseEntity<House>(new House(houseConfig.getHouseNumber(),1L), HttpStatus.OK);
	}
}
