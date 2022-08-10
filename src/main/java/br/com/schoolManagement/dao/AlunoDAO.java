package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Aluno;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Empresa;

public class AlunoDAO {
private EntityManager em;
	
	public AlunoDAO(EntityManager em) {
		this.em = em;
	}

// -- Creat	

	public void cadastrar(Aluno aluno) {
		this.em.persist(aluno);
	}
	
// -- Delete	
	
	public void remover(Aluno aluno) {
		this.em.remove(this.em.merge(aluno));
	}
	
	// -- Read	

	@SuppressWarnings("unchecked")
	public List<Aluno> findAll(){
		String query = "select a From Aluno a";
		return this.em.createQuery(query).getResultList();
	}
	
	public Aluno getById(long id) {
		return em.find(Aluno.class, id);
	}

	public List<Curso> findAllAlunosByCursoId(long id) {
		return null;
	}
	
	public Empresa getCurso(long id) {
		return null;
	}
	
// -- Alter	
}
