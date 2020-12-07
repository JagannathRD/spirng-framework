package com.xworkz.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.dao.RocketDAO;
import com.xworkz.dto.RocketDTO;

public class Tester {

	public static void main(String[] args) throws SQLException {
		//ApplicationContext container = new ClassPathXmlApplicationContext("resources/context.xml");

//		RocketDTO dto = container.getBean(RocketDTO.class);
//		System.out.println(dto.getCountry());
//
//		RocketDAO dao = container.getBean(RocketDAO.class);
//		try {
//			dao.save(dto);
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
		
		//dao.get(dto);
		//dao.update(dto);
	//	dao.delete(dto);
		
//		ClassPathXmlApplicationContext containerImpl = (ClassPathXmlApplicationContext) container;
//		containerImpl.close();
		
		//try with resource
		
		try( ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("resources/context.xml");
		
		){
			RocketDTO dto= context.getBean(RocketDTO.class);
			
			RocketDAO dao= context.getBean(RocketDAO.class);
			dao.save(dto);
		}
		}
	}



