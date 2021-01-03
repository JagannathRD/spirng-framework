package com.xworkz.covid.service;

import java.util.Objects;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xworkz.covid.dao.CovidDAO;
import com.xworkz.covid.dto.PatientDTO;

@Service
public class CovidServiceImpl implements CovidService {

	@Autowired
	private CovidDAO dao;

	public CovidServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSave(PatientDTO dto) {
		boolean valid = false;

		if (Objects.nonNull(dto)) {
			String name = dto.getName();
			if (!StringUtils.isEmpty(name) && name.length() > 3) {
				System.out.println("Name is valid");
				valid = true;
			} else {
				System.out.println("name is invalid");
				valid = false;
			}

			if (valid) {
				String email = dto.getEmail();

				if (!StringUtils.isEmpty(email)) {
					System.out.println("Email is valid");
					valid = true;
				} else {
					System.out.println("Email is invalid");
					valid = false;
				}
			}

			if (valid) {
				int age = dto.getAge();

				if (age > 60) {
					System.out.println("Age is valid");
					valid = true;
				} else {
					System.out.println("Age is invalid");
					valid = false;
				}
			}

			if (valid) {
				String state = dto.getState();

				if (!StringUtils.isEmpty(state)) {
					System.out.println("State is valid");
					valid = true;
				} else {
					System.out.println("State is invalid");
					valid = false;
				}
			}

//			if (valid) {
//				long mobile = dto.getMobile();
//				
//				if (mobile == 10) {
//					System.out.println("Mobile is valid");
//					valid = true;
//				} else {
//					System.out.println("Mobile is invalid");
//					valid = false;
//				}
//			}
			if (valid) {
				long id = dao.save(dto);
				System.out.println(id + " saved");
			} else {
				System.out.println("Invalid input...");
			}
		}

		return valid;
	}

}
