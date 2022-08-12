package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.AlunoDAO;
import br.com.schoolManagement.model.Aluno;
import br.com.schoolManagement.utils.JpaUtil;

public class AlunoController {

// -- Create
	
	@SuppressWarnings("unused")
	public static void create(Aluno aluno) {
		EntityManager em = JpaUtil.getEntityManager();
		AlunoDAO alunoDAO = new AlunoDAO(em);
		
		em.getTransaction().begin();
		
		// U BURACO É MAIS EM BAIXO
		
		em.getTransaction().commit();
		em.close();
	}
	public static void createMany(List<Aluno> alunos) {
		for(Aluno aluno: alunos)
			create(aluno);
	}
	
// -- Read

	public static List<Aluno> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		AlunoDAO alunoDAO = new AlunoDAO(em);
		
		em.getTransaction().begin();
		
		List<Aluno> alunos = alunoDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
	
		return alunos;
	}
	public static Aluno getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		AlunoDAO alunoDAO = new AlunoDAO(em);
		
		em.getTransaction().begin();
		
		Aluno aluno = alunoDAO.getById(id);
		
		em.getTransaction().commit();
		em.close();
	
		return aluno;
	}
	public static void getCursosByUnidade() {	
	}
	
	public static void getEmpresa() {
	
	}
		
// -- Update
	
	public static void update(long aluno_id, Aluno alunoNew) {
		EntityManager em = JpaUtil.getEntityManager();
		AlunoDAO alunoDAO = new AlunoDAO(em);
		
		em.getTransaction().begin();
		
		alunoDAO.updateDAO(aluno_id, alunoNew);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	
// -- Delete
	
	public static void deleteByID(long aluno_id) {
		EntityManager em = JpaUtil.getEntityManager();
		AlunoDAO alunoDAO = new AlunoDAO(em);
		
		Aluno aluno = getById(aluno_id);
		
		em.getTransaction().begin();
		
		alunoDAO.removerDAO(aluno);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	public static void deleteAll() {	
		List<Aluno> alunos = getAll();
		
		for(Aluno auno : alunos)
			deleteByID(auno.getId());
	}
}
