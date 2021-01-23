package com.xworkz.ecom.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.ServiceException;

@Service
public class EmailServiceImpl implements EmailService {

	static Logger logger=Logger.getLogger(EmailServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(ECommerceDTO commerceDTO) throws ServiceException {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(commerceDTO.getEmail());
		mailMessage.setSubject("Xworkz common module registration");
		mailMessage.setText("Hi " + commerceDTO.getfName() + "\n" + "\n"
				+ " your registraion is successful please login with username and password" + "\n" + "\n" + "\n"
				+ "Thanks," + "\n" + "X-workz");

		try {
			mailSender.send(mailMessage);
			return true;
		} catch (MailException e) {
			logger.error(e.getMessage());

			// throw new ServiceException(e.getMessage());

		}

		return false;

	}

}
