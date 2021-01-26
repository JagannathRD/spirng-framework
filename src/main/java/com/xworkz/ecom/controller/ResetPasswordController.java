package com.xworkz.ecom.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.ResetDTO;
import com.xworkz.ecom.exception.ControllerException;
import com.xworkz.ecom.exception.ServiceException;
import com.xworkz.ecom.service.ECommerceService;

@Controller
@RequestMapping("/")
public class ResetPasswordController {

	@Autowired
	ECommerceService service;
	
	static Logger logger=Logger.getLogger(ResetPasswordController.class);
	
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
