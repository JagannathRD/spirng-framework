package com.xworkz;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.flights.Flights;

public class Tester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/context.xml");

		Flights flights = context.getBean(Flights.class);
		ArrayList<String> arrayList = flights.getFlightsList();
		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
