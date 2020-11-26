package com.xworkz.breakfast;

public class Sun {
	private String color;
	private int age;
	private long distanceFromEarth;
	private int noOfPlanets;
	

	public Sun(String color,int age,long distanceFromEarth, int noOfPlanets ) {
		this.color=color;
		this.age=age;
		this.distanceFromEarth=distanceFromEarth;
		this.noOfPlanets=noOfPlanets;
		System.out.println(this.getClass().getSimpleName()+"color "+this.color+" age "+this.age+" distanceFromEarth "+this.distanceFromEarth+" noOfPlanets "+this.noOfPlanets );
	}
}
