package com.xworkz;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.xworkz.integration.dao.CoronaVaccineDAO;
import com.xworkz.integration.dao.Service;
import com.xworkz.integration.dto.CoronaVaccine;

public class Tester {

	public static void main(String[] args) {
		
		
		
//		CoronaVaccineDAO dao = new CoronaVaccineDAO();
//		dao.save(vaccine);

		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"resources/context.xml")) {
			
			
			CoronaVaccine vaccine = new CoronaVaccine();

			vaccine.setVaccineId(15);
			vaccine.setDevelopedBy("Sputnik");
			vaccine.setCountry("Russia");
			vaccine.setName(null);
			vaccine.setReadyForTest(true);
		
			Service service=applicationContext.getBean(Service.class);
			service.validateAndSave(vaccine);
			
			
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