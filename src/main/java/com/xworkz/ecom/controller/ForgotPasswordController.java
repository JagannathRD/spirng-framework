package com.xworkz.ecom.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.ControllerException;
import com.xworkz.ecom.exception.ServiceException;
import com.xworkz.ecom.service.ECommerceService;

@Controller
@RequestMapping("/")
public class ForgotPasswordController {

	@Autowired
	ECommerceService service;
	
	static Logger logger=Logger.getLogger(ForgotPasswordController.class);
	
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
	
}
