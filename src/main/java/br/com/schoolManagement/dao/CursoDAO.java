package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Curso;

public class CursoDAO {
	
	private EntityManager em;
	
	public CursoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Curso curso) {
		this.em.persist(curso);
	}
	
	public void remover(Curso curso) {
		this.em.remove(this.em.merge(curso));
	}
	
	public Curso getById(long id) {
		return em.find(Curso.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> findAll(){
        String query = "select c From Curso c";
        return this.em.createQuery(query).getResultList();
    }
}
