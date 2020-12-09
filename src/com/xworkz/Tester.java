package com.xworkz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.browser.Browser;
import com.xworkz.internet.Internet;
import com.xworkz.mobile.Mobile;
import com.xworkz.person.Person;

public class Tester {

	public static void main(String[] args) {
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("resources/context.xml");
		Person person=applicationContext.getBean(Person.class );
		person.call();
		
		System.out.println(person.getName());
		Mobile mobile=applicationContext.getBean(Mobile.class);
		
		System.out.println(mobile.getBrand());
		System.out.println(mobile.getImeiNo());
		
		Browser browser=applicationContext.getBean(Browser.class);
		browser.connect();
		
				
		ClassPathXmlApplicationContext context=(ClassPathXmlApplicationContext) applicationContext;
		context.close();
	}

}
