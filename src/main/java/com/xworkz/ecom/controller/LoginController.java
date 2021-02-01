package com.xworkz.ecom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.LoginDTO;
import com.xworkz.ecom.exception.ControllerException;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;
import com.xworkz.ecom.service.ECommerceService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	ECommerceService service;
	
	static Logger logger=Logger.getLogger(LoginController.class);
	
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
	
	
		@RequestMapping(value = {"login.do"}, method = RequestMethod.POST)
		public String doLogin(@ModelAttribute ECommerceDTO dto, @ModelAttribute LoginDTO loginDTO, Model m)
				throws ControllerException {
			try {
				
				List<ECommerceDTO> list=service.loginDetails(loginDTO.getEmail());
				String message = service.validateAndLogin(dto,loginDTO);
				
				for (ECommerceDTO eCommerceDTO : list) {
					logger.info(list);
					m.addAttribute("list", eCommerceDTO);
					
					logger.debug(message);
					if(message.equals("matching")){
						m.addAttribute("message","Hi "+eCommerceDTO.getfName());
						return "Home";
					}
				}
				
				if(message.equals("notMatching")){
					m.addAttribute("message","Incorrect password you only have 3 attempts");
					return "Login";
				}
				if(message.equals("trialsExceeded")){
					m.addAttribute("message","Password attempts exceeded your account will be locked, please use forgot password");
					return "Login";
				}
				if(message.equals("locked")){
					m.addAttribute("message","Your account is locked, please use forgot password");
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
		
		@RequestMapping(value="/editname/{email:.+}") 
		public String userDetails( @PathVariable("email") String email ,Model m) throws ControllerException{
			logger.info("Invoked fetch method");
			logger.info(email);
			try {
				List<ECommerceDTO> list=service.loginDetails(email);
				logger.info(list);
				for (ECommerceDTO eCommerceDTO : list) {
					m.addAttribute("list",eCommerceDTO);
					logger.info("inside for each");
					logger.info(eCommerceDTO.getfName());
				}
				
			} catch (ServiceException e) {
				throw new ControllerException(e.getMessage());
			}
			
			return "UserDetails";
			
		}

		@RequestMapping(value="/update", method=RequestMethod.POST ) 
		public String updateDetails(String email, String fName,String lName, Model m) throws ControllerException{
			logger.info("update method invoked");
			logger.info(email);
			try {
				service.updateNameByEmail(email, fName, lName);
				m.addAttribute("success","Update success");
			} catch (ServiceException e) {
				throw new ControllerException(e.getMessage());
			}
			
			return "spring-cm-page/Home";
			
		}
		
}
