package br.com.schoolManagement.dao;

import javax.persistence.EntityManager;

public class SchoolDAO<E> {

private EntityManager em;
	
	public void EmpresaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(E dao) {
		this.em.persist(dao);
	}
	
	public void remover(E dao) {
		this.em.remove(this.em.merge(dao));
	}
	
}
