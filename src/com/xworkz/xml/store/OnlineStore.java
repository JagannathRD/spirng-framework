package com.xworkz.xml.store;

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
