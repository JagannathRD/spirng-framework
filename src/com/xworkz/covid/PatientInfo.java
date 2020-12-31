package com.xworkz.covid;




import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.covid.dto.PatientDTO;

@Component
@RequestMapping("/")
public class PatientInfo {


	
	
	
	public PatientInfo() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/covid.do")
	public String save(@ModelAttribute PatientDTO dto,Model model){
		System.out.println(dto);
		
		
		
		model.addAttribute("dto",dto);
		
		
		
		return "info";
	}
}
