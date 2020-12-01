package com.xworkz.spring;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.spring.Hotel.Hotel;
import com.xworkz.spring.Hotel.Mobile;
import com.xworkz.spring.Hotel.Monitor;

public class Tester {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("resources/Context.xml");

		Hotel hotel = container.getBean(Hotel.class);
		hotel.getLocation();
		hotel.getTypeVeg();

		Mobile mobile = container.getBean("brand", Mobile.class);
		mobile.isLteSupported();

		Monitor monitor = container.getBean("monitor", Monitor.class);
		String date = monitor.getMfgDate();

		System.out.println("Mfg date: " + date);
		String modelNo = monitor.getModelNo();
		System.out.println("Model no: " + modelNo);

		String name = container.getBean("string", String.class);
		System.out.println("String value " + name);

		String name2 = container.getBean("str", String.class);
		System.out.println("String value " + name2);

		Integer integer = container.getBean("1", Integer.class);
		System.out.println("Integer value " + integer);

		Integer integer2 = container.getBean("int", Integer.class);
		System.out.println("Integer value " + integer2);

		Byte byte1 = container.getBean(Byte.class);
		System.out.println("Byte value " + byte1);

		Short short2 = container.getBean(Short.class);
		System.out.println("Short value " + short2);

		Long long2 = container.getBean(Long.class);
		System.out.println("Long value " + long2);

		Float float2 = container.getBean(Float.class);
		System.out.println("Float value " + float2);

		Character char1 = container.getBean(Character.class);
		System.out.println("Char value " + char1);

		Double double1 = container.getBean(Double.class);
		System.out.println("Double value " + double1);

		Boolean boolean1 = container.getBean(Boolean.class);
		System.out.println("Boolean value " + boolean1);
		
		
	}

}

/*
 * public class Hotel {
 * 
 * private String name;// init using const private boolean type;// init using
 * set private String location;/init using set
 * 
 * } public class Mobile{
 * 
 * private String brand;//init using const private double price;//init using
 * const private boolean lteSupported;// init using set
 * 
 * 
 * } public class Monitor{ private int width;//init using const private int
 * height;//init using const private String modelNo;//init using set private
 * String mfgDate;//init using set }
 * 
 * 
 * Declare a bean of string type and init "Xworkz" using its constructor Declare
 * beans for all Wrapper class and init values using constructor // Integer
 * value=new Integer(45);
 */
