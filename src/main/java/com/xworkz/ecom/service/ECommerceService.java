package com.xworkz.ecom.service;

import java.util.List;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.LoginDTO;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;

public interface ECommerceService {

	String validateAndSave (ECommerceDTO commerceDTO)throws ServiceException;
	
	List<ECommerceDTO> validateAndLogin(ECommerceDTO dto) throws ServiceException;
}
