package com.realestate.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.realestate.ms.config.HouseConfig;
import com.realestate.ms.model.House;

@RestController
@EnableHystrix
public class HouseController {
	
	@Autowired
	private HouseConfig houseConfig;
	
	private static Logger logger = LoggerFactory.getLogger(HouseController.class);
	
	@GetMapping(path = "/house/")
	public ResponseEntity<House> getHouse(){
		logger.info("Getting house details");
		return new ResponseEntity<House>(new House("CTS","Pune",1L), HttpStatus.OK);
	}
	
	@GetMapping(path="/house/fault")
	@HystrixCommand(fallbackMethod = "fallBackDefaultHouse")
	public ResponseEntity<House> testHystrixFaultTolerance(){
		logger.info("testing hystrix fault tolerance, raising runtime exception");
		throw new RuntimeException("Testing Hystrix Fault Tolerance");
	}
	
	public ResponseEntity<House> fallBackDefaultHouse(){
		logger.info("Invoked fallBackDefaultHouse as a result of fault");
		return new ResponseEntity<House>(new House(houseConfig.getHouseNumber(),houseConfig.getHouseStreet(),1L), HttpStatus.OK);
	}
	
}
