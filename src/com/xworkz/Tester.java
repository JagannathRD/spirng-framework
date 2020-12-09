package com.xworkz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.scope.Temple;

public class Tester {
	
	public static void main(String[] args) {
		System.out.println("mms");
		ApplicationContext context= new ClassPathXmlApplicationContext("resources/context.xml");
		Temple temple=context.getBean("tp",Temple.class);
		System.out.println(temple.getName());
		System.out.println(temple.getPlace());
		
		
		Temple temple2=context.getBean("tm",Temple.class);
		System.out.println(temple);
		System.out.println(temple2);
		System.out.println(temple2.getTempleList());
		Temple temple3=context.getBean("tp",Temple.class);
		System.out.println(temple3.hashCode());
		
		Temple temple4=context.getBean("templist",Temple.class);
		System.out.println(temple4);
	} 

	

}
