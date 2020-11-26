package com.xworkz.breakfast.hotel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.breakfast.Season;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Spring created.....");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/Context.xml");

		Owner owner = applicationContext.getBean(Owner.class);
		owner.manage();

//		Season season = applicationContext.getBean("season", Season.class);
//		Season season2 = applicationContext.getBean("summer", Season.class);
	}

}
