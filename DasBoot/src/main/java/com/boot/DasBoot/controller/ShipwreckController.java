package com.boot.DasBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.DasBoot.model.Shipwreck;
import com.boot.DasBoot.repository.ShipwreckRepository;

@Controller
@RequestMapping(path = "api/v1/")
public class ShipwreckController {
	
	@Autowired
	@Qualifier(value = "shipRepo")
	ShipwreckRepository shipwreckRepository;
	
	@GetMapping("shipwrecks")
	public ResponseEntity<List<Shipwreck>> listAll(){
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("x_status", "custom value");
		System.out.println("*******************"+this.getClass()+": list");
		return new ResponseEntity<List<Shipwreck>>(shipwreckRepository.findAll(),responseHeader,HttpStatus.OK);
	}
	
	@GetMapping("shipwreckslist")
	public List<Shipwreck> list(){
		System.out.println("*******************"+this.getClass()+": list");
		return shipwreckRepository.findAll();
	}
	
	@GetMapping("shipwrecks/{id}")
	public ResponseEntity<Shipwreck> list(@PathVariable Long id){
		System.out.println("*******************"+this.getClass()+": list: by id: " + id);
		return new ResponseEntity<Shipwreck>(shipwreckRepository.findById(id).get(),HttpStatus.OK);
	}
	
	@PostMapping("shipwrecks")
	public ResponseEntity<Shipwreck> create(@RequestBody Shipwreck entity) {
		System.out.println("*******************"+this.getClass()+": create: input entity" + entity);
		return new ResponseEntity<Shipwreck>(shipwreckRepository.saveAndFlush(entity),HttpStatus.OK);
	}
	
	@DeleteMapping("shipwrecks/{id}")
	public ResponseEntity<Shipwreck> delete(@PathVariable Long id) {
		System.out.println("*******************"+this.getClass()+": delete: by id: " + id);
		Shipwreck entity = shipwreckRepository.findById(id).get();
		shipwreckRepository.delete(entity);
		return new ResponseEntity<Shipwreck>(entity,HttpStatus.OK);
	}
	
	@PutMapping("shipwrecks/{id}")
	public ResponseEntity<Shipwreck> update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		System.out.println("*******************"+this.getClass()+": update: by id: " + id);
		Shipwreck existing = shipwreckRepository.findById(id).get();
		BeanUtils.copyProperties(shipwreck, existing);
		return new ResponseEntity<Shipwreck>(shipwreckRepository.saveAndFlush(existing),HttpStatus.OK);
	}
	
}
