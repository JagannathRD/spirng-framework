package com.xworkz.integration.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.integration.dto.CoronaVaccine;

public class CoronaVaccineDAO {

	SessionFactory factory;

	public CoronaVaccineDAO() {
		System.out.println(this.getClass().getSimpleName() + " created...");
	}

	public void save(CoronaVaccine vaccine) {
		Session session = null;
		Transaction transaction = null;

		try {
			Configuration configuration = new Configuration();
			configuration.configure("resources/hibernate.cfg.xml");
			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();

			session.save(vaccine);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (factory != null)
				factory.close();
		}

	}
}
