package com.xworkz.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.ServiceException;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {

	@Autowired
	private MailSender mailsender;
	
	@Override
	public boolean sendMail(ECommerceDTO commerceDTO, String otp) throws ServiceException {
		
		
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(commerceDTO.getEmail());
		mailMessage.setSubject("One Time Password");
		mailMessage.setText("Hello, "+"\n"+commerceDTO.getfName()+"\n"+"Please login with "+"\n"+"Email :"+commerceDTO.getEmail()+
				"\n"+"Password: "+otp);
		try{
		mailsender.send(mailMessage);
		return true;
		}catch(MailException e){
			throw new ServiceException(e.getMessage());
		}
	}

	

}
