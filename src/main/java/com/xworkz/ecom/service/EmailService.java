package com.xworkz.ecom.service;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.ServiceException;

public interface EmailService {

	boolean sendMail(ECommerceDTO commerceDTO)throws ServiceException;

	
}
