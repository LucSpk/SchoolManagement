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
	
// -- Read	

	public Professor getById(long id) {
		return em.find(Professor.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Professor> findAll(){
		String query = "select p From Professor p";
		return this.em.createQuery(query).getResultList();
	}
	
// -- Update	

	public void updateDAO(long id, Professor professor) {
		String query = "UPDATE Professor p "
				+ "SET p.nome = :name , "						
				+ "WHERE p.id = :id";
		this.em
			.createQuery(query)
			.setParameter("name", professor.getNome())
			.setParameter("id", id)
			.executeUpdate();	
	}
	
// -- Delete	

	public void remover(Professor professor) {
		this.em.remove(this.em.merge(professor));
	}
	
}
