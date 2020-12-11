package com.xworkz.earth;

public class Ocean {

	private String name;
	private Whale blueWhale;

	public Ocean() {
		System.out.println(this.getClass().getSimpleName() + " created....");
	}

	public void createsTsunami() {
		System.out.println(this.getClass().getSimpleName() + " creates tsunami....");
		this.blueWhale.swims();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Whale getBlueWhale() {
		return blueWhale;
	}

	public void setBlueWhale(Whale blueWhale) {
		this.blueWhale = blueWhale;
	}

	@Override
	public String toString() {
		return "Ocean [name=" + name + ", blueWhale=" + blueWhale + "]";
	}
}
