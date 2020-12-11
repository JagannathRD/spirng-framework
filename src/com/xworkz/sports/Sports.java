package com.xworkz.sports;

public class Sports {

	private String name;
	private int noOfPlayers;
	private String type;
	
	public Sports() {
	System.out.println(this.getClass().getSimpleName()+" created....");
	}
	
	public void toss(){
		System.out.println(this.getClass().getSimpleName()+" tossed....");
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
		return "Sports [name=" + name + ", noOfPlayers=" + noOfPlayers + ", type=" + type + "]";
	}
}
