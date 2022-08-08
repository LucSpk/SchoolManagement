package br.com.schoolManagement.dao;

import javax.persistence.EntityManager;

public class schoolDAO<E> {

private EntityManager em;
	
	public schoolDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(schoolDAO<E> dao) {
		this.em.persist(dao);
	}
	
	public void remover(schoolDAO<E> dao) {
		this.em.remove(this.em.merge(dao));
	}
}
