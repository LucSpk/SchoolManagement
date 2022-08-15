package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Aluno;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Professor;
import br.com.schoolManagement.model.ReferenciaDoCurso;

public class ReferenciaDoCursoDAO {

private EntityManager em;
	
	public ReferenciaDoCursoDAO(EntityManager em) {
		this.em = em;
	}

// -- Creat	

	public void cadastrarDAO(ReferenciaDoCurso referenciaDoCurso) {
		this.em.persist(referenciaDoCurso);
	}
	
// -- Read	

	public Professor getByIdDAO(long id) {
		return em.find(Professor.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Professor> findAllDAO(){
		String query = "SELECT r FROM ReferenciaDoCurso r ";
		return this.em.createQuery(query).getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Curso> findCursosDAO(long id) {
		String query = "SELECT r FROM ReferenciaDoCurso r WHERE r.curso.id = :id";
		return this.em
			.createQuery(query)
			.setParameter("id", id)
			.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<Aluno> findAlunosDAO(long id) {
		String query = "SELECT r FROM ReferenciaDoCurso r WHERE r.alunos.id = :id";
		return this.em
			.createQuery(query)
			.setParameter("id", id)
			.getResultList();	
	}
	
// -- Update	

// -- Delete	

	public void removerDAO(ReferenciaDoCurso referenciaDoCurso) {
		this.em.remove(this.em.merge(referenciaDoCurso));
	}
}
