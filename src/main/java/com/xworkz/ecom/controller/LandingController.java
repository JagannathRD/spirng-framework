package com.xworkz.ecom.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.ControllerException;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;
import com.xworkz.ecom.service.ECommerceService;
import com.xworkz.ecom.service.ECommerceServiceImpl;

@Controller
@RequestMapping("/")
public class LandingController {
	
	@Autowired
	ECommerceService service;

	public LandingController() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/landing.do", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute ECommerceDTO dto,HttpServletRequest request,Model m) throws ControllerException, RepositoryException{
		
		try {
			String saved=service.validateAndSave(dto);
			if(saved.equals("duplicate")){
				m.addAttribute("message", "Email is duplicte");
				System.out.println("Not saved");
			}
			else{
				System.out.println("Saved success");
			
				
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		
		
		
		return "LandingPage";
	}
}
