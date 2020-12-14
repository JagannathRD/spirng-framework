package com.xworkz.integration.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "corona_vaccine_table")
public class CoronaVaccine implements Serializable   {

	@Id
	@Column(name="v_id")
	private int vaccineId;
	@Column(name="v_name")
	private String name;
	@Column(name="v_country")
	private String country;
	@Column(name="v_developedB")
	private String developedBy;
	@Column(name="v_readyForTest")
	private boolean readyForTest;

	public CoronaVaccine() {
		System.out.println("corona vaccine dto...");
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDevelopedBy() {
		return developedBy;
	}

	public void setDevelopedBy(String developedBy) {
		this.developedBy = developedBy;
	}

	public boolean getReadyForTest() {
		return readyForTest;
	}

	public void setReadyForTest(boolean readyForTest) {
		this.readyForTest = readyForTest;
	}

	
}
