package com.xworkz.ecom.dao;

import java.util.List;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.LoginDTO;
import com.xworkz.ecom.dto.ResetDTO;
import com.xworkz.ecom.exception.RepositoryException;

public interface ECommerceDAO {

	public Integer save(ECommerceDTO dto)throws RepositoryException;
	
	public long fetchEmailCount(ECommerceDTO dto) throws RepositoryException;
	
	public List<ECommerceDTO> fetchRowByEmail(String email) throws RepositoryException;
	
	public String fetchPassword(ECommerceDTO dto) throws RepositoryException;
	
	public boolean isValidUser(ECommerceDTO dto) throws RepositoryException;

	List<ECommerceDTO> fetchTable(ECommerceDTO dto) throws RepositoryException;

	String updatePassword(ECommerceDTO commerceDTO) throws RepositoryException;

	boolean isValidOtp(ResetDTO dto) throws RepositoryException;

	boolean resetPassword( ResetDTO resetDTO) throws RepositoryException;

	public void updateLoginFailCount(String email,int count) throws RepositoryException;

	public void updateAccountLocked(String email, boolean locked)throws RepositoryException;

	public void updateNameByEmail(String email,String fName, String lName) throws RepositoryException;


}
