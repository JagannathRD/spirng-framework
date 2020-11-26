package com.xworkz.breakfast;

public class Earth {

	private boolean liveable;
	
	public Earth(boolean liveable) {
		this.liveable=liveable;
		System.out.println(this.getClass().getSimpleName()+" liveable: "+this.liveable);
}
	
}
