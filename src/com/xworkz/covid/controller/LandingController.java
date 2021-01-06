package com.xworkz.covid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LandingController {

	private List<String> states;
	
	public LandingController() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init method");
		this.states= new ArrayList<String>();
		this.states.add("KA");
		this.states.add("MH");
		this.states.add("UP");
		this.states.add("AP");
	}
	
	@RequestMapping("/landing.do")
	public String addStaes(Model model) {
		System.out.println("invoked add states");
		model.addAttribute("states", this.states);
		return "covid";
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("invoked destroy");
		this.states=null;
	}
}
