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

	
	
	
	
	
}
