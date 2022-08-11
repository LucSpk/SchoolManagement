package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Aluno;

public class AlunoDAO {
	
	private EntityManager em;
	
	public AlunoDAO(EntityManager em) {
		this.em = em;
	}

// -- Creat	

	public void cadastrar(Aluno aluno) {
		this.em.persist(aluno);
	}
		
// -- Read	
	
	public Aluno getById(long id) {
		return em.find(Aluno.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Aluno> findAll(){
		String query = "select a From Aluno a";
		return this.em.createQuery(query).getResultList();
	}
	
// -- Alter	
	
	public void updateDAO(long id, Aluno aluno) {
		String query = "UPDATE Aluno a "
				+ "SET a.nome = :name "
				+ "e.cpf = :cpf "
				+ "WHERE a.id = :id";
		this.em
			.createQuery(query)
			.setParameter("name", aluno.getNome())
			.setParameter("cpf", aluno.getCpf())
			.setParameter("id", id)
			.executeUpdate();	
	}
	
// -- Delete	

	public void remover(Aluno aluno) {
		this.em.remove(this.em.merge(aluno));
	}

}
