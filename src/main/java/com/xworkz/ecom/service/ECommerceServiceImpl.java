package com.xworkz.ecom.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.xworkz.ecom.dao.ECommerceDAO;
import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;

@Service
public class ECommerceServiceImpl implements ECommerceService {

	@Autowired
	private ECommerceDAO dao;

	public ECommerceServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@ModelAttribute
	public boolean validateAndSave(ECommerceDTO dto) throws ServiceException {
		boolean valid = false;
		boolean saved = false;
		
		
		if (Objects.nonNull(dto)) {
			String fName = dto.getfName();
			if (!fName.isEmpty() && fName.length() >= 3) {
				valid = true;
				
				System.out.println("Name is valid");
			} else {
				valid = false;
				System.out.println("Name is invalid");
			}
			if (valid) {
				String pass = dto.getPassword();
				String cPass = dto.getcPassword();
				if (pass.equals(cPass)) {
					valid = true;
					System.out.println("Passwords matching");
				} else {
					valid = false;
					System.out.println("Pasword is not matching");
				}
			}
			if (valid) {
				String email = dto.getEmail();
				String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
				if (email.matches(regex)) {
					valid = true;
					System.out.println("Email is valid");
				} else {
					valid = false;
					System.out.println("Email is invalid");
				}
			}
			if (valid) {
				try {
					dao.save(dto);
					System.out.println("Inputs are valid and saving");
					saved = true;
				} catch (RepositoryException e) {
					
					throw new ServiceException(e.getMessage());
				}catch (Exception e) {
					throw new ServiceException(e.getMessage());
				}
				
			} else {
				System.out.println("Inputs are invalid and notsaving");
			}

		} else {
			System.out.println("No Inputs");
		}

		return saved;
	}

}
