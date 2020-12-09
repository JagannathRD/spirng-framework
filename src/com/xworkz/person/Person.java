package com.xworkz.person;

import com.xworkz.mobile.Mobile;

public class Person {

	private String name;
	private Mobile mobile;
	
	
	public Person() {
		System.out.println(" this is "+this.getClass().getSimpleName());
	}
	public void call(){
		System.out.println(this.getClass().getSimpleName()+" calling...");
		this.mobile.call();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	
	
}
