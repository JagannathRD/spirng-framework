package com.xworkz.ecom.service;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;

public interface ECommerceService {

	String validateAndSave (ECommerceDTO commerceDTO)throws ServiceException;
	
	boolean sendMail(ECommerceDTO commerceDTO)throws ServiceException;
}
