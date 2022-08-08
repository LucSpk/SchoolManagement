package br.com.schoolManagement.dao;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Empresa;

public class EmpresaDAO {
	
	private EntityManager em;
	
	public EmpresaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Empresa empresa) {
		this.em.persist(empresa);
	}
	
	public void remover(Empresa empresa) {
		this.em.remove(this.em.merge(empresa));
	}
	
}
