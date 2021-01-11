package com.xworkz.ecom.service;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.ServiceException;

public interface ECommerceService {

	boolean validateAndSave (ECommerceDTO commerceDTO)throws ServiceException;
}
