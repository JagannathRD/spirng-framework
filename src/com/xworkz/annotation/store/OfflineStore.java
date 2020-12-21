package com.xworkz.annotation.store;


import org.springframework.stereotype.Component;

@Component
public class OfflineStore implements Order{

	@Override
	public boolean book() {
		System.out.println("booking food offline");
		return true;
	}

	@Override
	public boolean cancel() {
		System.out.println("canceling food offline");
		return true;
	}

}
