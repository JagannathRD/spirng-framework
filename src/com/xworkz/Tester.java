package com.xworkz;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.integration.Service;
import com.xworkz.integration.dao.CoronaVaccineDAO;
import com.xworkz.integration.dto.CoronaVaccine;

public class Tester {

	public static void main(String[] args) {
		
		
		
//		CoronaVaccineDAO dao = new CoronaVaccineDAO();
//		dao.save(vaccine);

		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"resources/context.xml")) {
			Service service=applicationContext.getBean(Service.class);
			CoronaVaccine vaccine = new CoronaVaccine();

			vaccine.setVaccineId(14);
			vaccine.setDevelopedBy("Sputnik");
			vaccine.setCountry("Russia");
			vaccine.setName("Sputnik");
			vaccine.setReadyForTest(true);
		
			String message=service.validateAndSave(vaccine);
			System.out.println(message);
			
			CoronaVaccineDAO dao=applicationContext.getBean(CoronaVaccineDAO.class);
			dao.get();
			System.out.println("------");
			
			dao.getCountry(1);
			System.out.println("------");
			
			dao.update("covi shield", "Russia", 2);
			System.out.println("------");
			
			dao.fetchDetails(2);
			System.out.println("------");
			
			dao.updateDetails("Sputnik", "Russia", 3);
			System.out.println("------");
			
			dao.deleteRow(10);
		}

	}
}