package com.xworkz.breakfast;

public class Season {
	private int temp;
	private String weather;
	
	public Season() {
	System.out.println(this.getClass().getSimpleName()+" default constructor");
	}
	
	public Season(int temp) {
		this.temp=temp;
		System.out.println(this.getClass().getSimpleName()+" 1arg constructor created...."+this.temp);
	}
	
	public Season(int temp, String weather) {
		this.weather=weather;
		this.temp=temp;
		System.out.println(this.getClass().getSimpleName()+" 2arg constructor created...."+this.weather+" "+this.temp);
	}
}
