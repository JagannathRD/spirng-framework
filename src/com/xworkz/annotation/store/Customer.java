package com.xworkz.annotation.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component 
public class Customer {

	private String name;
	private String email;
	
	
	//@Qualifier("offlineStore")
	private Order order;
	
	@Autowired
	public Customer(@Qualifier("offlineStore") Order order) {
		System.out.println("created..." + this.getClass().getSimpleName());
		this.order=order;
	}

	public void orderFood() {
		this.order.book();
	}

	public void cancelFood() {
		this.order.cancel();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Order getOrder() {
//		return order;
//	}
//	
//	public void setOrder(Order order) {
//		this.order = order;
//	}
}
