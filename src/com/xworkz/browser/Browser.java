package com.xworkz.browser;

import com.xworkz.internet.Internet;

public class Browser {

	private Internet internet;
	
	public Browser() {
		System.out.println("this is "+this.getClass().getSimpleName());
	}
	public void connect(){
		System.out.println("connecting.."+this.getClass().getSimpleName());
		
	}

	public Internet getInternet() {
		return internet;
	}

	public void setInternet(Internet internet) {
		this.internet = internet;
	}
}
