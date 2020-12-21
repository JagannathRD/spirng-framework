package com.xworkz.annotation.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class OnlineStore implements Order{

	@Override
	public boolean book() {
		
		System.out.println("booking food online");
		return true;
	}

	@Override
	public boolean cancel() {
		System.out.println("canceling food online");
		return true;
	}

}
