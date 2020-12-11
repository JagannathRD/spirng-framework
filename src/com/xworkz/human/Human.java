package com.xworkz.human;

public class Human {
	private String name;
	private int age;
	private Heart heart;

	public Human(String name, int age, Heart heart) {
		this.name = name;
		this.age = age;
		this.heart = heart;
		System.out.println(this.getClass().getSimpleName() + " created.....");
	}

	public void bloodFlows() {
		System.out.println(this.getClass().getSimpleName()+" blood flows....");
		this.heart.pumpsBlood();
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}

}
