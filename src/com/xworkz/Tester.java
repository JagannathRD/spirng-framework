package com.xworkz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.vehivle.Battery;
import com.xworkz.vehivle.Fuel;
import com.xworkz.vehivle.Vehicle;

public class Tester {
public static void main(String[] args) {
	Battery battery= new Battery();
	battery.setCapacity(10);
	battery.setPower(15);
	
	Fuel fuel= new Fuel();
	fuel.setPrice(85.05);
	fuel.setType("gas");
	fuel.setQuantity(10);
	
	
	Vehicle vehicle= new Vehicle(4907, "jaggu", battery); 
	vehicle.start(fuel);
	vehicle.setFuel(fuel);
	
//	ApplicationContext context= new ClassPathXmlApplicationContext("resources/context.xml");
//	Vehicle vehicle=context.getBean(Vehicle.class);
//	vehicle.start();
}
}
