package com.xworkz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.integration.dao.CoronaVaccineDAO;
import com.xworkz.integration.dto.CoronaVaccine;

public class Tester {

	public static void main(String[] args) {
		

//		CoronaVaccineDAO dao = new CoronaVaccineDAO();
//		dao.save(vaccine);

		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"resources/context.xml")) {
			CoronaVaccineDAO dao= applicationContext.getBean(CoronaVaccineDAO.class);
			CoronaVaccine vaccine = new CoronaVaccine();

			vaccine.setVaccineId(11);
			vaccine.setDevelopedBy("Pfizer");
			vaccine.setCountry("USA");
			vaccine.setName("Pfizer");
			vaccine.setReadyForTest(true);
//			dao.save(vaccine);
			
			dao.get(vaccine);
			dao.getCountry(1);
			dao.update("covi shield", "Russia", 2);
		}

	}
}