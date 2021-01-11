package com.xworkz.ecom.dao;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.RepositoryException;

public interface ECommerceDAO {

	public String save(ECommerceDTO dto)throws RepositoryException;
}
