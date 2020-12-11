package com.xworkz.earth;

public class Earth {
	private boolean liveable;
	private long distanceFromSun;
	private Ocean pacific;

	public Earth() {
		System.out.println(this.getClass().getSimpleName() + " created.....");
	}

	public void rotates() {
		System.out.println(this.getClass().getSimpleName() + " rotates.....");
		this.pacific.createsTsunami();
	}

	public boolean isLiveable() {
		return liveable;
	}

	public void setLiveable(boolean liveable) {
		this.liveable = liveable;
	}

	public long getDistanceFromSun() {
		return distanceFromSun;
	}

	public void setDistanceFromSun(long distanceFromSun) {
		this.distanceFromSun = distanceFromSun;
	}

	public Ocean getPacific() {
		return pacific;
	}

	public void setPacific(Ocean pacific) {
		this.pacific = pacific;
	}

	@Override
	public String toString() {
		return "Earth [liveable=" + liveable + ", distanceFromSun=" + distanceFromSun + ", pacific=" + pacific + "]";
	}

	
}
