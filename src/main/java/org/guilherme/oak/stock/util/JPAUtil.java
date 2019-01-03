package org.guilherme.oak.stock.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("inventory");
	EntityManager em = emf.createEntityManager();

	public EntityManager getEntityManager() {
		return em;
	}

}
