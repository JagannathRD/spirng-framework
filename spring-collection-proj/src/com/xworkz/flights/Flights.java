package com.xworkz.flights;

import java.util.ArrayList;
import java.util.TreeSet;

public class Flights {

	private ArrayList<String> flightsList;
	private TreeSet<String> airports;

	public Flights() {
		System.out.println(this.getClass().getSimpleName() + " Created");
	}

	public ArrayList<String> getFlightsList() {
		return flightsList;
	}

	public void setFlightsList(ArrayList<String> flightsList) {
		this.flightsList = flightsList;
	}

	public TreeSet<String> getAirports() {
		return airports;
	}

	public void setAirports(TreeSet<String> airports) {
		this.airports = airports;
	}

}
