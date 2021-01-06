package com.xworkz.covid;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.covid.dto.PatientDTO;
import com.xworkz.covid.exception.ControllerException;
import com.xworkz.covid.exception.ServiceException;
import com.xworkz.covid.service.CovidService;

@Controller
@RequestMapping("/")
public class PatientInfo {

@Autowired
private CovidService service;
	
	
	
	public PatientInfo() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/covid.do")
	public String save(@ModelAttribute PatientDTO dto,Model model) throws  ControllerException{
		System.out.println(dto);
				
				
		try {
			boolean success=service.validateAndSave(dto);
			
			model.addAttribute("dto",dto);
			System.out.println("Saved "+success);
			
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "infon";
	}
}
