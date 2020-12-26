package com.xworkz.navigation;

import org.springframework.stereotype.Component;

@Component
public class Map {

	public Map() {
		System.out.println("Created.."+this.getClass().getSimpleName());
	}
}
