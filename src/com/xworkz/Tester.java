package com.xworkz;

import com.xworkz.integration.dao.CoronaVaccineDAO;
import com.xworkz.integration.dto.CoronaVaccine;

public class Tester {

	public static void main(String[] args) {
		CoronaVaccine vaccine= new CoronaVaccine();
		
		
//		vaccine.setVaccineId(5);
//		vaccine.setDevelopedBy("Pfizer");
//		vaccine.setCountry("USA");
//		vaccine.setName("Pfizer");
//		vaccine.setReadyForTest(true);
//	
		CoronaVaccineDAO dao= new  CoronaVaccineDAO();
		dao.save(vaccine);
 
}
}