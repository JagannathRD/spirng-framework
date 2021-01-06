package com.xworkz.covid.dto;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Patient_dto")
public class PatientDTO implements Serializable{

	@Id
	@GenericGenerator(strategy="increment", name = "ref" )
	@GeneratedValue(generator="ref")
	private long id;
	private String name;
	private int age;
	private String email;
	private String mobile;
	private String result;
	private String state;
	
	public PatientDTO() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "PatientDTO [name=" + name + ", age=" + age + ", email=" + email + ", mobile=" + mobile + ", result="
				+ result + ", state=" + (state) + "]";
	}

	
	
	
}
