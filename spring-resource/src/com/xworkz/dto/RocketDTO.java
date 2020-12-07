package com.xworkz.dto;

import java.io.Serializable;
import java.util.Date;

public class RocketDTO implements Serializable {

	private String country;
	private Date launchDate;
	private double cost;
	
	public void init(){
		System.out.println();
	}
	public RocketDTO() {
		System.out.println("rocket dto"); 
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
		System.out.println("set country");
	}


	public Date getLaunchDate() {
		return launchDate;
	}


	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}
}
