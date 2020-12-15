package com.xworkz.integration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.integration.dto.CoronaVaccine;

public class CoronaVaccineDAO {

	SessionFactory factory;

	public CoronaVaccineDAO(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName() + " created...");
		this.factory = factory;
	}

	public void save(CoronaVaccine vaccine) {
		Session session = null;
		Transaction transaction = null;

		try {
			// Configuration configuration = new Configuration();
			// configuration.configure("resources/hibernate.cfg.xml");
			// factory = configuration.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();

			session.save(vaccine);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	public void fetchDetails(int id) {
		Session session = null;
		System.out.println("fetch");
		CoronaVaccine vaccine = null;
		try {
			session = factory.openSession();
			vaccine = session.get(CoronaVaccine.class, id);
			System.out.println(vaccine);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void get(CoronaVaccine vaccine) {
		Session session = null;
		List<CoronaVaccine> list = null;
		System.out.println("fetch by list");
		try {
			session = factory.openSession();
			Query query = session.createQuery("from CoronaVaccine");
			list = (List<CoronaVaccine>) query.list();
			for (CoronaVaccine coronaVaccine : list) {
				System.out.println(coronaVaccine);
			}

			System.out.println(vaccine);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

	}

	public String getCountry(int id) {
		Session session = null;
		String country = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select country from CoronaVaccine where vaccineId=:id");
			query.setParameter("id", id);
			country = (String) query.uniqueResult();
			System.out.println(country);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return null;

	}

	public void update(String name, String country, int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update CoronaVaccine set name=:n,country=:c where vaccineId=:id");
			query.setParameter("n", name);
			query.setParameter("c", country);
			query.setParameter("id", id);

			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	public void updateDetails(String name, String country, int id) {
		Session session = null;
		Transaction transaction = null;
		CoronaVaccine vaccine = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			vaccine = session.get(CoronaVaccine.class, id);
			if (vaccine != null) {
				vaccine.setName(name);
				vaccine.setCountry(country);
				session.update(vaccine);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	public void deleteRow(int id) {

		Session session = null;
		Transaction transaction = null;
		CoronaVaccine vaccine = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			vaccine = session.get(CoronaVaccine.class, id);
			if (vaccine != null) {
				session.delete(vaccine);
			}

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
