package com.xworkz;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.earth.Earth;
import com.xworkz.human.Human;
import com.xworkz.vehivle.Battery;
import com.xworkz.vehivle.Fuel;
import com.xworkz.vehivle.Vehicle;

public class Tester {
public static void main(String[] args) {
//	Battery battery= new Battery();
//	battery.setCapacity(10);
//	battery.setPower(15);
//	
//	Fuel fuel= new Fuel();
//	fuel.setPrice(85.05);
//	fuel.setType("gas");
//	fuel.setQuantity(10);
//	
//	
//	Vehicle vehicle= new Vehicle(4907, "jaggu", battery); 
//	
//	vehicle.setFuel(fuel);
//	vehicle.start();
	try(ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("resources/vehicleContext.xml")){
	Vehicle vehicle=context.getBean(Vehicle.class);
	vehicle.start();
	}
	
	try(ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("resources/context.xml")){
		Human human= context.getBean(Human.class);
		System.out.println(human);
		human.bloodFlows();
		
		}
	
	try(ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("resources/context.xml")){
		Earth earth= context.getBean(Earth.class);
		System.out.println(earth);
		earth.rotates();
		
		}
}
}
