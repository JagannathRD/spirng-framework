package com.xworkz.integration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.integration.dto.ElectionResultsDto;

public class ElectionResultsImpl implements ElectionResultsInterface {
	
	private SessionFactory factory;
	
	public ElectionResultsImpl(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName()+" created...");
		this.factory=factory;
	}

	@Override
	public void save(ElectionResultsDto dto) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=factory.openSession();
			transaction=session.beginTransaction();
			session.save(dto);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(transaction !=null)
				transaction.rollback();
			
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		
	}

	@Override
	public void updateWardNoById(int wardNo, long id) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=factory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery("update ElectionResultsDto set wardNO=:n where resultId=:i");
			query.setParameter("n", wardNo);
			query.setParameter("i", id);
			query.executeUpdate();
			transaction.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
			if(transaction!=null)
				transaction.rollback();
		}finally {
			if(session!=null)
				session.close();
		}
		
		
	}

	@Override
	public ElectionResultsDto getByPartyName(String name) {
		
		return null;
	}

	@Override
	public List<ElectionResultsDto> getList() {
		
		return null;
	}

}
