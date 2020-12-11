package com.xworkz.sports;

public class Tennis {
	private boolean lawn;
	private String name;
	private int noOfPlayers;
	private String type;

	public Tennis() {
		System.out.println(this.getClass().getSimpleName() + " created.....");
	}

	public void service() {
		System.out.println(this.getClass().getSimpleName() + " service.....");
	}

	public boolean isLawn() {
		return lawn;
	}

	public void setLawn(boolean lawn) {
		this.lawn = lawn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Tennis [lawn=" + lawn + ", name=" + name + ", noOfPlayers=" + noOfPlayers + ", type=" + type + "]";
	}
}
