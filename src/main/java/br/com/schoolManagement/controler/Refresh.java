package br.com.schoolManagement.controler;

import javax.persistence.EntityManager;

import br.com.schoolManagement.utils.JpaUtil;

public class Refresh {

	public static void begin() {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
}
