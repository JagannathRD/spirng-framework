package com.xworkz.navigation;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class Home {

	public Home() {
		System.out.println("Created..." + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/home.do", params = "click")
	public String call(HttpServletRequest request) {
		System.out.println("Invoked home on call....");

		Enumeration<String> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			String param = en.nextElement();
			System.out.println("param " + param);
			System.out.println(request.getParameter(param));
		}
		return "home";
	}

	@RequestMapping(value = "/home.do", params = { "search" })
	public String search() {

		return "search";
	}

	@RequestMapping(value = "/home.do", params = { "add" })
	public String add() {
		System.out.println("Invoked add...");
		return "add";
	}

}
