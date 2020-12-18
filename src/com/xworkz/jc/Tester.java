package com.xworkz.jc;

import java.util.Arrays;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext container=new ClassPathXmlApplicationContext("resources/context.xml")){
			System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
			
		}

	}

}
