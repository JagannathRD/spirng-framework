package com.xworkz.ecom.dto;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "e_commerce")
public class ECommerceDTO implements Serializable {

	@Id
	@Column(name="f_name")
	private String fName;
	@Column(name="l_name")
	private String lName;

	private String email;
	
	private String password;
	
	@Transient
	private String cPassword;

	public ECommerceDTO() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	@Override
	public String toString() {
		return "ECommerceDTO [fName=" + fName + ", lName=" + lName + ", email=" + email + ", password=" + password
				+ ", cPassword=" + cPassword + "]";
	}

}
