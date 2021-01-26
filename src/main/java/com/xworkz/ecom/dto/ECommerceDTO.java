package com.xworkz.ecom.dto;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "register_table")
public class ECommerceDTO implements Serializable {

	static Logger logger=Logger.getLogger(ECommerceDTO.class);
	
	@Id
	@GenericGenerator(strategy="increment", name = "ref")
	@GeneratedValue(generator="ref")
	private int id;
	
	@Column(name="f_name")
	private String fName;
	
	@Column(name="l_name")
	private String lName;

	private String email;
	
	private String password;
	
	@Transient
	private String cPassword;
	
	@Column(name="invalid_login_count")
	private int invalidLoginCount;
	
	@Column(name="account_status_locked")
	private boolean accountStatusLocked;

	public ECommerceDTO() {
		logger.info("Created " + this.getClass().getSimpleName());
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

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInvalidLoginCount() {
		return invalidLoginCount;
	}

	public void setInvalidLoginCount(int invalidLoginCount) {
		this.invalidLoginCount = invalidLoginCount;
	}

	public boolean isAccountStatusLocked() {
		return accountStatusLocked;
	}

	public void setAccountStatusLocked(boolean accountStatusLocked) {
		this.accountStatusLocked = accountStatusLocked;
	}

	@Override
	public String toString() {
		return "ECommerceDTO [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", cPassword=" + cPassword + ", invalidLoginCount=" + invalidLoginCount
				+ ", accountStatusLocked=" + accountStatusLocked + "]";
	}

}
