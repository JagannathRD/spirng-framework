package com.xworkz.ecom.dao;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.ecom.dto.ECommerceDTO;
import com.xworkz.ecom.dto.LoginDTO;
import com.xworkz.ecom.dto.ResetDTO;
import com.xworkz.ecom.exception.RepositoryException;

@Repository
public class ECommerceDAOImpl implements ECommerceDAO {

	static Logger logger = Logger.getLogger(ECommerceDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public ECommerceDAOImpl() {
		logger.info("Ceated " + this.getClass().getSimpleName());
	}

	public Integer save(ECommerceDTO dto) throws RepositoryException {
		Session session = null;
		Transaction transaction = null;
		Integer id = dto.getId();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			id = (Integer) session.save(dto);
			logger.debug(id);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {

			throw new RepositoryException(e.getMessage());

		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	public long fetchEmailCount(ECommerceDTO dto) throws RepositoryException {
		Session session = null;
		long n;
		String email = dto.getEmail();
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(*) from ECommerceDTO where email=:e ");
			query.setParameter("e", email);
			n = (Long) query.uniqueResult();
			logger.debug(n);
			logger.debug(n);
		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {

			throw new RepositoryException(e.getMessage());

		}finally {
			if (session != null)
				session.close();
		}
		return n;
	}

	@Override
	public List<ECommerceDTO> fetchTable(ECommerceDTO dto) throws RepositoryException {
		List<ECommerceDTO> list = null;
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from ECommerceDTO ");

			list = (List<ECommerceDTO>) query.list();

		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<ECommerceDTO> fetchRowByEmail(String email) throws RepositoryException {
		List<ECommerceDTO> list = null;
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from ECommerceDTO where email=:e");
			query.setParameter("e", email);
			logger.info(email);
			list = (List<ECommerceDTO>) query.list();
			logger.info(list.size());
			for (ECommerceDTO eCommerceDTO : list) {
				logger.info(eCommerceDTO);
			}

		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public String fetchPassword(ECommerceDTO dto) throws RepositoryException {
		Session session = null;
		String password = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select password from ECommerceDTO where email=:e");
			query.setParameter("e", dto.getEmail());
			password = (String) query.uniqueResult();

		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return password;
	}
	
	
	
	@Override
	public void updateLoginFailCount(String email, int count) throws RepositoryException {
		Session session = null;
		int status = 0;
		Transaction transaction=null;
		try {
			session = factory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("update ECommerceDTO set invalidLoginCount=:c where email=:e");
			query.setParameter("c", count);
			query.setParameter("e", email);
			
			 status=query.executeUpdate();
			logger.debug(status);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
	};

	
	
	@Override
	public  void updateAccountLocked(String email,boolean locked) throws RepositoryException {
		Session session = null;
		int status = 0;
		Transaction transaction=null;
		try {
			session = factory.openSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("update ECommerceDTO set accountStatusLocked=:b where email=:e");
			query.setParameter("b", locked);
			query.setParameter("e", email);
			
			 status=query.executeUpdate();
			logger.debug(status);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		};
		
		
	@Override
	public boolean isValidUser(ECommerceDTO dto) throws RepositoryException {
		Session session = null;
		long count = 0;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(1) from ECommerceDTO where email=:e and password=:p");
			query.setParameter("e", dto.getEmail());
			query.setParameter("p", dto.getPassword());

			count = (long) query.uniqueResult();
			if (count > 0)
				return true;
		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}
	
	

	@Override
	public String updatePassword(ECommerceDTO commerceDTO) throws RepositoryException {
		Session session = null;
		String randomString = null;
		Transaction transaction = null;
		randomString = RandomStringUtils.random(5, true, false);
		logger.debug(randomString);
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update ECommerceDTO set password=:p where email=:e");
			query.setParameter("e", commerceDTO.getEmail());
			query.setParameter("p", randomString);

			int status = query.executeUpdate();
			logger.debug(status);
			transaction.commit();
			return randomString;
		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		

	}

	@Override
	public boolean isValidOtp(ResetDTO dto) throws RepositoryException {
		Session session = null;
		long count = 0;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(*) from ECommerceDTO where password=:p");

			query.setParameter("p", dto.getPassword());

			count = (long) query.uniqueResult();
			if (count > 0)
				return true;
		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean resetPassword( ResetDTO resetDTO) throws RepositoryException {
		Session session = null;

		Transaction transaction = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update ECommerceDTO set password=:p where password=:q");
			query.setParameter("p", resetDTO.getNewPassword());
			query.setParameter("q", resetDTO.getPassword());
			
			
			int status = query.executeUpdate();
			logger.debug(status);
			transaction.commit();
			return true;
		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		
	}

	@Override
	public void updateNameByEmail(String email, String fName, String lName) throws RepositoryException {
		
		Session session = null;

		Transaction transaction = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update ECommerceDTO set fName=:f , lName=:l where email=:e");
			query.setParameter("f", fName);
			query.setParameter("l", lName);
			query.setParameter("e", email);
			
			int status = query.executeUpdate();
			logger.debug(status);
			transaction.commit();
			
		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
	}

}
