package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Curso;

public class CursoDAO {
	
	private EntityManager em;
	
	public CursoDAO(EntityManager em) {
		this.em = em;
	}
	
// -- Creat	

	public void cadastrar(Curso curso) {
		this.em.persist(curso);
	}
		
// -- Reade	
	
	public Curso getByIdDAO(long id) {
		return em.find(Curso.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Curso> findAllDAO() {
        String query = "select c From Curso c";
        return this.em.createQuery(query).getResultList();
    }

// -- Update

	public void updateDAO(long id, Curso curso) {
		String query = "UPDATE Empresa e "
				+ "SET e.nome = :name , "
				+ "WHERE e.id = :id";
		this.em
			.createQuery(query)
			.setParameter("name", curso.getNome())
			.setParameter("id", id)
			.executeUpdate();	
	}
	
// -- Delete	

	public void remover(Curso curso) {
		this.em.remove(this.em.merge(curso));
	}

}

