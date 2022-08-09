package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Unidade;

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
	
	public Empresa getById(long id) {
		return em.find(Empresa.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> findAll(){
        String query = "select e From Empresa e";
        return this.em.createQuery(query).getResultList();
    }
	
	public List<Unidade> findUnidadeByEmpresaId(long id){
        String query = "select u From Unidade u WHERE u.empresa.id = :id";
        return this.em
        		.createQuery(query, Unidade.class)
        		.setParameter("id", id)
        		.getResultList();
    }
	
}
