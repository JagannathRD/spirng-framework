package com.xworkz.ecom.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.ecom.dao.ECommerceDAO;
import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;

@Service
public class ECommerceServiceImpl implements ECommerceService {

	static Logger logger=Logger.getLogger(ECommerceServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private ECommerceDAO dao;

	public ECommerceServiceImpl() {
		//System.out.println("Created " + this.getClass().getSimpleName());
		logger.info("Created " + this.getClass().getSimpleName());
	}

	
	public String validateAndSave(ECommerceDTO dto) throws ServiceException {
		boolean valid = false;
		String message="NA";
		
		
		if (Objects.nonNull(dto)) {
			String fName = dto.getfName();
			if (!fName.isEmpty() && fName.length() >= 3) {
				valid = true;
				//System.out.println("Name is valid");
				logger.debug("Name is valid");
			} else {
				valid = false;
				logger.debug("Name is invalid");
			}
			if (valid) {
				String pass = dto.getPassword();
				String cPass = dto.getcPassword();
				if (pass.equals(cPass)) {
					valid = true;
					logger.debug("Passwords matching");
				} else {
					valid = false;
					logger.debug("Pasword is not matching");
				}
			}
			if (valid) {
				String email = dto.getEmail();
				
				String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
				if (email.matches(regex)) {
					valid = true;
					logger.debug("Email is valid");
				} else {
					valid = false;
					logger.debug("Email is invalid");
				}
			}
			if (valid) {
				
				try {
					if(dao.fetchEmailCount(dto)>0){
						message="duplicate";
					}else{
					dao.save(dto);
					logger.debug("Inputs are valid and saving");
					message="saved";
					}
				} catch (RepositoryException e) {
					
					throw new ServiceException(e.getMessage());
				}catch (Exception e) {
					throw new ServiceException(e.getMessage());
				}
				
			} else {
				logger.debug("Inputs are invalid and notsaving");
			}

		} else {
			logger.debug("No Inputs");
		}

		return message;
	}


	public boolean sendMail(ECommerceDTO commerceDTO) throws ServiceException {
		
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(commerceDTO.getEmail());
		mailMessage.setSubject("Xworkz common module registration");
		mailMessage.setText("Hi "+commerceDTO.getfName()+"\n"+"\n"+" your registraion is successful please login with username and password"+
		"\n"+"\n"+"\n"+"Thanks,"+"\n"+"X-workz");
		
		try{
			mailSender.send(mailMessage);
			return true;
		}catch (MailException e) {
			logger.error(e.getMessage());
			
			//throw new ServiceException(e.getMessage());
			
		}
		
		 return false;
		
	}

	
	
}
