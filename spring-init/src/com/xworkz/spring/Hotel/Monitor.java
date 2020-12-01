package com.xworkz.spring.Hotel;

public class Monitor {
	private int width;// init using const
	private int height;// init using const
	private String modelNo;// init using set
	private String mfgDate;// init using set
	
	public Monitor(int width,int height) {
		this.width=width;
		this.height=height;
		System.out.println(this.getClass().getSimpleName()+" 2-arg constructor "+this.height+" "+this.width);
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}
}
