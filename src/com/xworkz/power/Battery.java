package com.xworkz.power;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Battery {
	//@Value("15")
	private int capacity;
	//@Value("nippon")
	private String name;
	//@Autowired
	private Bulb bul;
	
	
	public Battery(@Value("15") int cap, @Value("nippon")String nm) {
		this.capacity=cap;
		this.name=nm;
	}
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Bulb getBul() {
		return bul;
	}
	public void setBul(Bulb bul) {
		this.bul = bul;
	}
}
