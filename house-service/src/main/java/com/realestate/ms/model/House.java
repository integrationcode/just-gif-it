package com.realestate.ms.model;

public class House {
	private String houseNumber;
	private String houseStreet;
	private Long floor;
	public House(String houseNumber, String houseStreet, Long floor) {
		super();
		this.houseNumber = houseNumber;
		this.houseStreet = houseStreet;
		this.floor = floor;
	}
	public House() {}
	
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
	public String getHouseStreet() {
		return houseStreet;
	}
	public void setHouseStreet(String houseStreet) {
		this.houseStreet = houseStreet;
	}
	
	@Override
	public String toString() {
		return "House [houseNumber=" + houseNumber + ", houseStreet=" + houseStreet + ", floor=" + floor + "]";
	}
	
	
}
