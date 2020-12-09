package com.xworkz.scope;

import java.util.ArrayList;

public class Temple {
	private String name;
	private String place;
	private ArrayList<String> templeList;
	
	public Temple(String name) {
		this.name=name;
		System.out.println("created temple..."+name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public ArrayList<String> getTempleList() {
		return templeList;
	}
	public void setTempleList(ArrayList<String> templeList) {
		this.templeList = templeList;
	}
	

}
