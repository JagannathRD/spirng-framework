package com.xworkz.ecom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.RepositoryException;

@Repository
public class ECommerceDAOImpl implements ECommerceDAO{

	@Autowired
	private SessionFactory factory;
	
	public ECommerceDAOImpl() {
		System.out.println("Ceated "+this.getClass().getSimpleName());
	}
		
	public String save(ECommerceDTO dto) throws RepositoryException {
		Session session=null;
		Transaction transaction=null;
		String name=dto.getfName();
		try {
			session=factory.openSession();
			transaction=session.beginTransaction();
			name=(String)session.save(dto);
			System.out.println(name);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null){
				transaction.rollback();
			}
			throw new RepositoryException(e.getMessage());
			
		}finally {
			if(session!=null)
				session.close();
		}
		return name;
	}

}
