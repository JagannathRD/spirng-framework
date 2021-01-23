package com.xworkz.ecom.dao;

import java.util.List;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.ResetDTO;
import com.xworkz.ecom.exception.RepositoryException;

public interface ECommerceDAO {

	public String save(ECommerceDTO dto)throws RepositoryException;
	
	public long fetchEmailCount(ECommerceDTO dto) throws RepositoryException;
	
	public List<ECommerceDTO> fetchRow(ECommerceDTO dto) throws RepositoryException;
	
	public String fetchPassword(ECommerceDTO dto) throws RepositoryException;
	
	public boolean isValidUser(ECommerceDTO dto) throws RepositoryException;

	List<ECommerceDTO> fetchTable(ECommerceDTO dto) throws RepositoryException;

	String updatePassword(ECommerceDTO commerceDTO) throws RepositoryException;

	boolean isValidOtp(ResetDTO dto) throws RepositoryException;

	boolean resetPassword( ResetDTO resetDTO) throws RepositoryException;
}
