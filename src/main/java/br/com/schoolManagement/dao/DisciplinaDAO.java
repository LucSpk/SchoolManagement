package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Disciplina;

public class DisciplinaDAO {
	
	private EntityManager em;
	
	public DisciplinaDAO(EntityManager em) {
		this.em = em;
	}
	
// -- Creat
	
	public void cadastrar(Disciplina disciplina) {
		this.em.persist(disciplina);
	}
	
// -- Delete
	
	public void remover(Disciplina disciplina) {
		this.em.remove(this.em.merge(disciplina));
	}
	
// -- Read
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> findAll() {
        String query = "select d From Disciplina d";
        return this.em.createQuery(query).getResultList();
    }
	
	public Disciplina getById(long id) {
		return em.find(Disciplina.class, id);
	}
	
// -- Alter

}
