package com.xworkz.spring.Hotel;

public class Mobile {
	private String brand;//init using const			
	private double price;//init using const			
	private boolean lteSupported;// init using set	
	
	public Mobile(String brand) {
		this.brand=brand;
		System.out.println(this.getClass().getSimpleName()+" calling 1-arg constructor..."+brand);
	}

	public Mobile(double price) {
		this.price=price;
		System.out.println(this.getClass().getSimpleName()+" calling 1-arg constructor..."+price);

	}
	
	public boolean isLteSupported() {
		System.out.println("lte Supported? "+this.lteSupported);
		return  lteSupported;
	}

	public void setLteSupported(boolean lteSupported) {
		this.lteSupported = lteSupported;
	}
}
