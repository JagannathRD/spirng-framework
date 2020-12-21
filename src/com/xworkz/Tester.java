package com.xworkz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.power.Battery;

public class Tester {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext container= new ClassPathXmlApplicationContext("resources/context.xml")){
			Battery battery=container.getBean(Battery.class);
			int cap=battery.getCapacity();
			System.out.println(cap);
			System.out.println(battery.getName());
		}

	}

}
