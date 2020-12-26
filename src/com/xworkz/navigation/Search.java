package com.xworkz.navigation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class Search {

	public Search() {
		System.out.println("Created..." + this.getClass().getSimpleName());
	}

	public void searchCountry(HttpServletRequest request) {

		String name = request.getParameter("nam");
		System.out.println(name);

	}

	@RequestMapping("/search.do")
	public String validateCountry(HttpServletRequest request) {
		System.out.println("Invoked search...");
		String name = request.getParameter("nam");
		System.out.println(name);
		if (name.equalsIgnoreCase("india")) {
			return "search";
		} else {
			return "home";
		}

	}

}
