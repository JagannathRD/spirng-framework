package com.xworkz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.sports.Sports;
import com.xworkz.sports.Tennis;

public class Tester {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("resources/context.xml")){
			
			Sports sports=applicationContext.getBean(Sports.class);
			System.out.println(sports);
			
			Tennis tennis=applicationContext.getBean(Tennis.class);
			System.out.println(tennis);
		}

	}

}
