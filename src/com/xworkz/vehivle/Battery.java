package com.xworkz.vehivle;

public class Battery {

	private double capacity;
	private int power;

	public Battery() {
		System.out.println(this.getClass().getSimpleName() + " created...");
	}

	public boolean charge() {
		boolean charging = false;
		if (power > 12) {
			System.out.println(this.getClass().getSimpleName() + " charges....");
			charging = true;
		} else {
			System.out.println(this.getClass().getSimpleName() + " not charging....");
		}
		return charging;
	}

	public boolean discharge() {
		boolean working = false;
		if (capacity > 0) {
			working = true;
			System.out.println(this.getClass().getSimpleName() + " discharges....");
		} else {
			System.out.println(this.getClass().getSimpleName() + " does not discharge....");
		}
		return working;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
