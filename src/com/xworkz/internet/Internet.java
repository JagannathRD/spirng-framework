package com.xworkz.internet;

import com.xworkz.power.Power;

public class Internet {

	private String providerName;
	private String state;
	private int code;
	private Power power;
	
	public Internet(Power power) {
		System.out.println("This is "+this.getClass().getSimpleName());
		this.power=power;
	}
	
	public void connect(){
		if(this.power.isAvailable())
			System.out.println("connecting.."+this.getClass().getSimpleName());
		
	}
	
	public void serverDown(){
		System.out.println("Internet serverDown......");
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}
}
