package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.AlunoDAO;
import br.com.schoolManagement.model.Aluno;
import br.com.schoolManagement.utils.JpaUtil;

public class AlunoController {

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

	public static List<Aluno> getUnidades() {
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
		
// -- Edit
		
// -- Delete	
}
