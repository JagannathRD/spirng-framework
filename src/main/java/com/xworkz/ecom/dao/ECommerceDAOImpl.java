package com.xworkz.ecom.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.exception.RepositoryException;

@Repository
public class ECommerceDAOImpl implements ECommerceDAO{

	static Logger logger=Logger.getLogger(ECommerceDAOImpl.class);
	
	@Autowired
	private SessionFactory factory;
	
	public ECommerceDAOImpl() {
		logger.info("Ceated "+this.getClass().getSimpleName());
	}
		
	public String save(ECommerceDTO dto) throws RepositoryException {
		Session session=null;
		Transaction transaction=null;
		String name=dto.getfName();
		try {
			session=factory.openSession();
			transaction=session.beginTransaction();
			name=(String)session.save(dto);
			logger.debug(name);
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

	public long fetchEmailCount(ECommerceDTO dto) throws RepositoryException {
		Session session=null;
		long n; 
		String email=dto.getEmail();
		try {
			session=factory.openSession();
			Query query= session.createQuery("select count(*) from ECommerceDTO where email=:e ");
			query.setParameter("e", email);
			n=(Long)query.uniqueResult();
			logger.debug(n);
			
		} catch (Exception e) {
			
			throw new RepositoryException(e.getMessage());
			
		}finally {
			if(session!=null)
				session.close();
		}
		return n;
	}

}
