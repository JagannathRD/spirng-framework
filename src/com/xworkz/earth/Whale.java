package com.xworkz.earth;

public class Whale {

	private double weight;
	private boolean mammal;
	
	public Whale() {
		System.out.println(this.getClass().getSimpleName()+" created.....");
	}
	
	public void swims(){
		System.out.println(this.getClass().getSimpleName()+" swims......");
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isMammal() {
		return mammal;
	}

	public void setMammal(boolean mammal) {
		this.mammal = mammal;
	}

	@Override
	public String toString() {
		return "Whale [weight=" + weight + ", mammal=" + mammal + "]";
	}
}
