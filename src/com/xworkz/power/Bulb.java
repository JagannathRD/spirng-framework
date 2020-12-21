package com.xworkz.power;

import org.springframework.stereotype.Component;

@Component
public class Bulb {

	public Bulb() {
		System.out.println("created "+this.getClass().getSimpleName());
	}
}
