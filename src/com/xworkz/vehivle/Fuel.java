package com.xworkz.vehivle;

public class Fuel {
	private String type;
	private double price;
	private double quantity;

	public Fuel() {
		System.out.println(this.getClass().getSimpleName() + " created......");
	}

	public String burn() {
		String burning ="not";

		if (quantity > 0) {
			System.out.println(this.getClass().getSimpleName() + " burns......");
			burning = "yes";
		} else {
			System.out.println(this.getClass().getSimpleName() + " not burns......");
		}
		return burning;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
