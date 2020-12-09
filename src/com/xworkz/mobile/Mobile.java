package com.xworkz.mobile;

public class Mobile {

	private String brand;
	private long imeiNo;

	public Mobile() {
		System.out.println("this is " + this.getClass().getSimpleName());
	}

	public void call() {
		System.out.println(this.getClass().getSimpleName() + " calling");
	}

	public void sendSms() {
		System.out.println(this.getClass().getSimpleName() + " sending sms");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(long imeiNo) {
		this.imeiNo = imeiNo;
	}
}
