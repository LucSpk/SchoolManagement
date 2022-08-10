package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.ProfessorDAO;
import br.com.schoolManagement.model.Professor;
import br.com.schoolManagement.utils.JpaUtil;

public class ProfessorController {
	
// -- Create

	@SuppressWarnings("unused")
	public static void create(Professor professor) {
		EntityManager em = JpaUtil.getEntityManager();
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		
		em.getTransaction().begin();
		
		// U BURACO É MAIS EM BAIXO
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void createMany(List<Professor> professores) {
		for(Professor professor: professores)
			create(professor);
	}
	
// -- Read

	public static List<Professor> getUnidades() {
		EntityManager em = JpaUtil.getEntityManager();
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		
		em.getTransaction().begin();
		
		List<Professor> professores = professorDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
	
		return professores;
	}
	
	public static Professor getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		
		em.getTransaction().begin();
		
		Professor professor = professorDAO.getById(id);
		
		em.getTransaction().commit();
		em.close();
	
		return professor;
	}
	
	public static void getCursosByUnidade() {
		
	}
	
	public static void getEmpresa() {
	
	}
		
// -- Edit
		
// -- Delete	
}
