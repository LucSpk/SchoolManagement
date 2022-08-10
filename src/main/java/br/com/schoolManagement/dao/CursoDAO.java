package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Unidade;

public class CursoDAO {
	
	private EntityManager em;
	
	public CursoDAO(EntityManager em) {
		this.em = em;
	}
	
// -- Creat	

	public void cadastrar(Curso curso) {
		this.em.persist(curso);
	}
	
// -- Delete	
	
	public void remover(Curso curso) {
		this.em.remove(this.em.merge(curso));
	}
	
// -- Reade	
	
	@SuppressWarnings("unchecked")
	public List<Curso> findAll() {
        String query = "select c From Curso c";
        return this.em.createQuery(query).getResultList();
    }
	
	public Curso getById(long id) {
		return em.find(Curso.class, id);
	}
	
	public void findPeriodosByCursoId(long id) {
		
	}
	
	public Unidade getUnidade(long id) {
		return null;
	}
	
}
