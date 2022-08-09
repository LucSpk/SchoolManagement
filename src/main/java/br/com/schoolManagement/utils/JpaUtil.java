package br.com.schoolManagement.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final EntityManagerFactory FACTORY = 
			Persistence.createEntityManagerFactory("jpa_treino");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
	public static void closeEntityManagerFactory() {
		FACTORY.close();
	}
}