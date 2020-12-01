package com.xworkz.spring.Hotel;

public class Hotel {

	private String name;
	private String location;
	private boolean typeVeg;
	
	public Hotel(String name) {
		this.name=name;
		System.out.println(this.getClass().getSimpleName()+" "+this.name); 
	}

	public String getLocation() {
		System.out.println(" Location "+location);
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		
	}

	public boolean getTypeVeg() {
		System.out.println(" type veg:"+typeVeg);
		return typeVeg;
	}

	public void setTypeVeg(boolean type) {
		this.typeVeg = type;
		
	}
	
	
}
