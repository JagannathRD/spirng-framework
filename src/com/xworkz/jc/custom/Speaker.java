package com.xworkz.jc.custom;

import org.springframework.stereotype.Component;

@Component

public class Speaker {

	
	public Speaker() {
		System.out.println("created "+this.getClass().getSimpleName());
	}
}
