package com.xworkz.xml.store;

public class Customer {

	private String name;
	private String email;

	Order order;

	public Customer() {
		System.out.println("created..." + this.getClass().getSimpleName());
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
