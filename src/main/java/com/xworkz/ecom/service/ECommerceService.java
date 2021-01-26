package com.xworkz.ecom.service;

import java.util.List;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.LoginDTO;
import com.xworkz.ecom.dto.ResetDTO;
import com.xworkz.ecom.exception.RepositoryException;
import com.xworkz.ecom.exception.ServiceException;

public interface ECommerceService {

	String validateAndSave (ECommerceDTO commerceDTO)throws ServiceException;
			
	String validateAndLogin(ECommerceDTO dto, LoginDTO dto2) throws ServiceException;
	
	boolean isValidUser(ECommerceDTO dto) throws ServiceException;

	boolean resetPassword(ECommerceDTO dto) throws ServiceException;

	String validateAndUpdatePassword( ResetDTO resetDTO) throws ServiceException;

	List<ECommerceDTO> loginDetails(ECommerceDTO dto) throws RepositoryException;
}
