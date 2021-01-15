package com.xworkz.ecom.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.xworkz.ecom.constants.AppConstants;
import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.ControllerException;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;
import com.xworkz.ecom.service.ECommerceService;
import com.xworkz.ecom.service.ECommerceServiceImpl;

@Controller
@RequestMapping("/")
public class LandingController {
	
	static Logger logger= Logger.getLogger(LandingController.class);
	
	@Autowired
	ECommerceService service;

	public LandingController() {
		//System.out.println("Created "+this.getClass().getSimpleName());
		logger.info("Created "+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/landing.do", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute ECommerceDTO dto,Model m) throws ControllerException, RepositoryException{
		
		try {
			String saved=service.validateAndSave(dto);
			if(saved.equals("duplicate")){
				m.addAttribute("message", "This Email already exists");
				//System.out.println("Not saved");
				logger.debug("Not saved");
			}
			if(saved.equals("saved")){
				m.addAttribute("success", "Registration Success");
				//System.out.println("Saved success");
				logger.debug("Saved success");
				boolean sent=service.sendMail(dto);
				if(sent){
					//System.out.println("Sent succesfully");
					logger.debug("Sent succesfully");
					m.addAttribute("meesage","Mail sent successfully");
				}else{
					//System.out.println("Sending failed");
					logger.debug("Sending failed");
					m.addAttribute("meesage","Sending failed");
				}
							
			}
			else if(saved.equals("NA")){
				m.addAttribute("message", "Data is invalid");
				//System.out.println("Data is invalid- Not saved");
				logger.debug("Data is invalid- Not saved");
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		
		
		
		return AppConstants.LandingPage;
	}
}
