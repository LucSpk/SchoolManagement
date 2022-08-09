package br.com.schoolManagement.dao;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Unidade;

public class UnidadeDAO {

	private EntityManager em;
	
	public UnidadeDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Unidade unidade) {
		this.em.persist(unidade);
	}
	
	public void remover(Unidade unidade) {
		this.em.remove(this.em.merge(unidade));
	}
	
}
