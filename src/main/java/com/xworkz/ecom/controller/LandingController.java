package com.xworkz.ecom.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.xworkz.ecom.constants.AppConstants;
import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.LoginDTO;
import com.xworkz.ecom.dto.ResetDTO;
import com.xworkz.ecom.exception.ControllerException;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;
import com.xworkz.ecom.service.ECommerceService;
import com.xworkz.ecom.service.ECommerceServiceImpl;

@Controller
@RequestMapping("/")
//@SessionAttributes("name")
public class LandingController {

	static Logger logger = Logger.getLogger(LandingController.class);

	@Autowired
	ECommerceService service;

	public LandingController() {
		// logger.debug("Created "+this.getClass().getSimpleName());
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/landing.do", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute ECommerceDTO dto, Model m)
			throws ControllerException, RepositoryException {

		try {

			String saved = service.validateAndSave(dto);

			if (saved.equals("duplicate")) {
				m.addAttribute("message", "This Email already exists");
				// logger.debug("Not saved");
				logger.debug("Not saved");
			}

			if (saved.equals("saved")) {
				m.addAttribute("success", "Registration Success-Email sent");
				// logger.debug("Saved success");
				logger.debug("Saved success");

			}

			if (saved.equals("NA")) {
				m.addAttribute("message", "Data is invalid");
				// logger.debug("Data is invalid- Not saved");
				logger.debug("Data is invalid- Not saved");
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}

		return AppConstants.LandingPage;
	}

	// @SessionScope("name")
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute ECommerceDTO dto, @ModelAttribute LoginDTO loginDTO, Model m)
			throws ControllerException {
		try {
			List<ECommerceDTO> list=service.loginDetails(dto);
			String message = service.validateAndLogin(dto,loginDTO);
			
			for (ECommerceDTO eCommerceDTO : list) {
				
				logger.debug(message);
				if(message.equals("matching")){
					m.addAttribute("message","Hi "+eCommerceDTO.getfName());
					return "Home";
				}
			}
			
			if(message.equals("notMatching")){
				m.addAttribute("message","password and confirm password matching");
				return "Login";
			}if(message.equals("notRegistered")){
				m.addAttribute("message","This is not a registered email");
				return "Login";
			}

		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "Login";

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String login(@ModelAttribute ECommerceDTO dto, @ModelAttribute LoginDTO loginDTO, Model m)
			throws ControllerException {

		try {
			boolean validUser = service.isValidUser(dto);
			if (validUser) {
				m.addAttribute("message", "Login Success");
				m.addAttribute("name", "Hi " + loginDTO.getEmail());
				return "Home";
			} else {
				m.addAttribute("message", "user name or password not matching");
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		return "Login";

	}
	
	@RequestMapping(value="forgot.do", method=RequestMethod.POST)
	public String forgot(@ModelAttribute ECommerceDTO commerceDTO, Model m) throws ControllerException{
		
		try {
			boolean reset=service.resetPassword(commerceDTO);
			if(!reset){
				m.addAttribute("message","This email is not registered");
				return "Fpassword";
				
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		return "Reset";
		
	}
	
	@RequestMapping(value="reset.do", method=RequestMethod.POST)
	public String resetPassword(@ModelAttribute ResetDTO dto,@ModelAttribute ECommerceDTO commerceDTO, Model m) throws ControllerException{
		try {
			String vaildAndUpdated=service.validateAndUpdatePassword( dto);
			
			if(vaildAndUpdated.equals("valid")){
			m.addAttribute("reset","Password updated");
			}
			else if(vaildAndUpdated.equals("invalid")){
			m.addAttribute("reset","Invalid otp");	
			}
			else if(vaildAndUpdated.equals("notMatching")){
				m.addAttribute("reset","Password and confirm password not matching");	
			}
			else if(vaildAndUpdated.equals("NA")){
				m.addAttribute("reset","Please fill fields with valid data");	
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		return "Reset";
	}
	
}
