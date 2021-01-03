package com.xworkz.covid;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.covid.dto.PatientDTO;
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
	public String save(@ModelAttribute PatientDTO dto,Model model){
		System.out.println(dto);
		
			
		model.addAttribute("dto",dto);
		
		boolean success=service.validateAndSave(dto);
		
		System.out.println("Saved "+success);
		return "info";
	}
}
