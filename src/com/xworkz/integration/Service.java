package com.xworkz.integration;

import com.xworkz.integration.dao.CoronaVaccineDAO;
import com.xworkz.integration.dto.CoronaVaccine;

public class Service {

	private CoronaVaccineDAO dao;

	public Service(CoronaVaccineDAO dao) {
		System.out.println(this.getClass().getSimpleName() + " created...");
		this.dao = dao;
	}

	public String validateAndSave(CoronaVaccine vaccine) {
		String message = "failed";
		if (vaccine != null) {
			boolean valid = false;

			System.out.println("vaccine is an object....");

			String country = vaccine.getCountry();
			String developedBy = vaccine.getDevelopedBy();
			String name = vaccine.getName();
			int id = vaccine.getVaccineId();

			if (country != null && !country.isEmpty()) {
				System.out.println("country is valid");
				valid = true;
			} else {
				System.out.println("country is not  valid");
				valid = false;
			}

			if (developedBy != null && !developedBy.isEmpty()) {
				System.out.println("developedBy is valid");
				valid = true;
			} else {
				System.out.println("developedBy is not  valid");
				valid = false;
			}

			if (name != null && !name.isEmpty()) {
				System.out.println("name is valid");
				valid = true;
			} else {
				System.out.println("name is not  valid");
				valid = false;
			}

			if (id > 0) {
				System.out.println("id is valid");
				valid = true;
			} else {
				System.out.println("id is not  valid");
				valid = false;
			}

			if (valid) {
				dao.save(vaccine);
				message = "saved";
				System.out.println("saved");
			} else {
				message = "failed";
				System.out.println("failed");
			}

		} else {
			System.out.println("vaccine is not an object....");
		}
		return message;

	}

}
