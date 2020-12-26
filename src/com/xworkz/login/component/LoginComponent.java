package com.xworkz.login.component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Component
@RequestMapping("/")
public class LoginComponent {

	public LoginComponent() {
		System.out.println("created.."+this.getClass().getSimpleName());
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String validate(String user, String password, HttpServletRequest request){
	String name="jaggu";
	String pass="secret";
	
	
	if(name.equals(user)&&pass.equals(password))
	{
		System.out.println("logging...");
		request.setAttribute("message", "welcome, "+user);
		return "home";
	}
	else
	{
		System.out.println("user name or password is not correct");
		request.setAttribute("error", "user name or password is not correct");
		return "index";
	}

}
}
