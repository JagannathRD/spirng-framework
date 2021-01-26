package com.xworkz.ecom.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.ecom.dao.ECommerceDAO;
import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.LoginDTO;
import com.xworkz.ecom.dto.ResetDTO;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;

@Service
public class ECommerceServiceImpl implements ECommerceService {

	static Logger logger = Logger.getLogger(ECommerceServiceImpl.class);

	@Autowired
	private ECommerceDAO dao;

	@Autowired
	EmailService emailService;

	@Autowired
	PasswordResetService passwordResetService;

	public ECommerceServiceImpl() {
		// logger.debug("Created " + this.getClass().getSimpleName());
		logger.info("Created " + this.getClass().getSimpleName());
	}

	public String validateAndSave(ECommerceDTO dto) throws ServiceException {
		boolean valid = false;
		String message = "NA";

		if (Objects.nonNull(dto)) {
			String fName = dto.getfName();
			if (!fName.isEmpty() && fName.length() >= 3) {
				valid = true;
				// logger.debug("Name is valid");
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

					if (dao.fetchEmailCount(dto) > 0) {
						message = "duplicate";
					}

					else {
						boolean sent = emailService.sendMail(dto);

						if (sent) {
							dao.save(dto);
							logger.debug("Inputs are valid and saving");
							message = "saved";
						} else {
							logger.debug("Regiser unsuccessful-email not sent");
						}
					}
				} catch (RepositoryException e) {

					throw new ServiceException(e.getMessage());
				} catch (Exception e) {
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
	
	@Override
	public List<ECommerceDTO> loginDetails(ECommerceDTO dto) throws RepositoryException{
		List<ECommerceDTO> list=dao.fetchRow(dto);
		return list;
		
		
	}

	public String validateAndLogin(ECommerceDTO dto,LoginDTO loginDTO) throws ServiceException {
		String message=null;
		boolean accountLocked=false;
		int failedLogin=0;
		try {
			List<ECommerceDTO> list = dao.fetchRow(dto);
			
			
			for (ECommerceDTO eCommerceDTO : list) {
			accountLocked=eCommerceDTO.isAccountStatusLocked();
			
			logger.info("Account locked "+accountLocked);
			
			if(accountLocked==false){
					if (list.size() == 1) {

						logger.info(eCommerceDTO.getfName());
						logger.info(list.size());

						if (eCommerceDTO.getPassword().equals(loginDTO.getPassword())) {
							logger.info("password matching");
							dao.updateLoginFailCountToZero(loginDTO.getEmail());
							logger.info("update login count to zero method");
							message = "matching";
						}

						else {
							failedLogin= eCommerceDTO.getInvalidLoginCount();
							
							if (failedLogin < 3){
								dao.updateLoginFailCount(loginDTO);
								message="notMatching";
								logger.info("password not matching");
							}
							
							else{
								dao.updateAccountLocked(loginDTO);
								message = "trialsExceeded";
								logger.info("trials exceeded");
							}
							
							logger.info(eCommerceDTO);
							}
						
					}else {

						logger.info("User not registered");
						message = "notRegistered";
							}
				} if(accountLocked==true) {

					logger.info("Account Locked");
					message = "locked";
						}

			}
			

		} catch (RepositoryException e) {

			throw new ServiceException(e.getMessage());
		}
		return message;

	}

	@Override
	public boolean isValidUser(ECommerceDTO dto) throws ServiceException {

		try {
			boolean validUser = dao.isValidUser(dto);
			if (validUser)
				return true;
		} catch (RepositoryException e) {

			throw new ServiceException(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean resetPassword(ECommerceDTO dto) throws ServiceException {
		logger.debug("Invoked reset password method");
		try {
			long count = dao.fetchEmailCount(dto);
			logger.debug(count);
			if (count == 1) {
				String oTP = dao.updatePassword(dto);
				List<ECommerceDTO>list= dao.fetchRow(dto);
				for (ECommerceDTO eCommerceDTO : list) {
					boolean sent = passwordResetService.sendMail(eCommerceDTO, oTP);
					dao.updateLoginFailCountToZero(dto.getEmail());
					dao.updateAccountLockedToFalse(dto.getEmail());
					logger.debug("Email sent " + sent);
				}
				
				

				return true;
			}
		} catch (RepositoryException e) {
			throw new ServiceException(e.getMessage());
		}
		return false;

	}

	@Override
	public String validateAndUpdatePassword( ResetDTO resetDTO) throws ServiceException {

		logger.debug("invoked validateAndUpdatePassword");
		String message = "NA";
		boolean valid = false;
		try {
			if (!resetDTO.getPassword().isEmpty() && !resetDTO.getNewPassword().isEmpty()
					&& !resetDTO.getcPassword().isEmpty()) {
				valid = true;
			}
			if (valid) {
				if (resetDTO.getNewPassword().equals( resetDTO.getcPassword())) {

					boolean validOtp = dao.isValidOtp(resetDTO);
					logger.debug(validOtp);
					
					if (validOtp) {
						dao.resetPassword( resetDTO);
						logger.debug("otp is valid and password updated");
						return "valid";
					} else {
						logger.debug("Invalid otp");

						return "invalid";
					}

				} else {
					logger.debug("password and confirm password not matching...");
					return "notMatching";
				}
			} else {
				logger.debug("fields can't be blank");
				return message;
			}

		} catch (RepositoryException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
