package com.xworkz.ecom.dao;

import java.util.List;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.RepositoryException;

public interface ECommerceDAO {

	public String save(ECommerceDTO dto)throws RepositoryException;
	
	public long fetchEmailCount(ECommerceDTO dto) throws RepositoryException;
	
	public List<ECommerceDTO> fetchRow(ECommerceDTO dto) throws RepositoryException;
	
	public String fetchPassword(ECommerceDTO dto) throws RepositoryException;
}
