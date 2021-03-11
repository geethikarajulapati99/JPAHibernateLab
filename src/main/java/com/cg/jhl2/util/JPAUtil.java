package com.cg.jhl2.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "postgrePU";
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			entityManager = factory.createEntityManager();
		}
		return  entityManager;
	}
	
	public static void shutdown() {
		if (entityManager != null) {
			entityManager.close();
			if(factory !=null) {
				factory.close();
			}
		}
	}
}
