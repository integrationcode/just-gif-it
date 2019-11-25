package com.realestate.ms.model;

public class House {
	private String houseNumber;
	private Long floor;
	public House(String houseNumber, Long floor) {
		super();
		this.houseNumber = houseNumber;
		this.floor = floor;
	}
	public House() {
		
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Long getFloor() {
		return floor;
	}
	public void setFloor(Long floor) {
		this.floor = floor;
	}
	
	@Override
	public String toString() {
		return "House [houseNumber=" + houseNumber + ", floor=" + floor + "]";
	}
	
	
	
}
