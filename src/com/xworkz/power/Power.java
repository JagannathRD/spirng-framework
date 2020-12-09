package com.xworkz.power;

public class Power {

	private boolean available;
	
	
	public Power() {
		System.out.println("this is "+this.getClass().getSimpleName());
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void lightens(){
		System.out.println("lightening.....");
	}
	
	public void powercut(){
		System.out.println("Darkens...");
	}
}
