package com.xworkz.ecom.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class ResetDTO implements Serializable {

	static Logger logger = Logger.getLogger(ResetDTO.class);

	private String password;
	private String newPassword;
	private String cPassword;

	public ResetDTO() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	@Override
	public String toString() {
		return "ResetDTO [password=" + newPassword + ", newPassword=" + newPassword + ", cPassword=" + cPassword + "]";
	}

}
