package com.xworkz.ecom.service;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.ServiceException;

public interface PasswordResetService {

	boolean sendMail(ECommerceDTO dto,String otp) throws ServiceException;
}
