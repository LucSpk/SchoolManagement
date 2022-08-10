package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Professor;

public class ProfessorDAO {
	
private EntityManager em;
	
	public ProfessorDAO(EntityManager em) {
		this.em = em;
	}

// -- Creat	

	public void cadastrar(Professor professor) {
		this.em.persist(professor);
	}
	
// -- Delete	
	
	public void remover(Professor professor) {
		this.em.remove(this.em.merge(professor));
	}
	
	// -- Read	

	@SuppressWarnings("unchecked")
	public List<Professor> findAll(){
		String query = "select p From Professor p";
		return this.em.createQuery(query).getResultList();
	}
	
	public Professor getById(long id) {
		return em.find(Professor.class, id);
	}

	public List<Professor> findAllAlunosByCursoId(long id) {
		return null;
	}
	
	public Professor getCurso(long id) {
		return null;
	}
	
// -- Alter	

}
