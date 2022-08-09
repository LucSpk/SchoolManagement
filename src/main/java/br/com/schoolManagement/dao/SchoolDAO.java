package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class SchoolDAO<E> {

private EntityManager em;
	
	public SchoolDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(E dao) {
		this.em.persist(dao);
	}
	
	public void remover(E dao) {
		this.em.remove(this.em.merge(dao));
	}
	
	public List<Object> consultarPorNomePessoa(String nome) {
		String query = "SELECT e FROM Endereco e WHERE e.pessoa.nome = :nome";
		return this.em
				.createQuery(query, Object.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
}
