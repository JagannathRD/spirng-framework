package com.xworkz.vehivle;

public class Vehicle {
	private int regNo;
	private String owner;
	private Battery battery;
	private Fuel fuel;

	public Vehicle(int regNo, String owner, Battery battery) {
		System.out.println(this.getClass().getSimpleName() + " created...");
		this.regNo = regNo;
		this.owner = owner;
		this.battery = battery;
	}

	public boolean start() {
		
		boolean starts = false;
		if (battery.charge() && battery.discharge()) {
			String burning=fuel.burn();
			if (burning.equals("yes")) {
				System.out.println("vehicle starts....");
				starts = true;
			}
			else
				System.out.println("no fuel vehicle does not start....");
		} 
		else
			System.out.println("vehicle does not start...");
		return starts;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

}
