package com.xworkz.breakfast;

public class Moon {

	private int age;
	private boolean beautiful;
	private boolean isLiveable;
	
	public Moon(int age, boolean beautiful) {
		this.age=age;
		this.beautiful=beautiful;		
		System.out.println(this.getClass().getSimpleName()+" "+this.age +" Beutiful "+this.beautiful);
	}
	
	public Moon(boolean isLiveable,int age) {
		this.age=age;
		this.isLiveable=isLiveable;
		System.out.println(this.getClass().getSimpleName()+" "+this.age +" Liveable "+this.isLiveable);
	}
}
