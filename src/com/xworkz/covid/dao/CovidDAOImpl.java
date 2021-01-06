package com.xworkz.covid.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

import com.xworkz.covid.dto.PatientDTO;
import com.xworkz.covid.exception.RepositoryException;

//@Repository
public class CovidDAOImpl implements CovidDAO {

	private SessionFactory factory;
	
	

	
	public CovidDAOImpl(SessionFactory factory) {
		System.out.println("Created " + this.getClass().getSimpleName());
		this.factory=factory;
	}

	
	
	@Override
	public long save(PatientDTO dto) throws RepositoryException {

		Session session = null;
		Transaction transaction = null;
		long id=dto.getId();
		try {
//			Configuration configuration = new Configuration();
//			configuration.configure();
//			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();

			
			
			id=(long) session.save(dto);
			transaction.commit();
		}catch(Exception e){
			throw new RepositoryException(e.getMessage());
		}
		finally {
			if (session != null) {
				session.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		return id;
	}

}
