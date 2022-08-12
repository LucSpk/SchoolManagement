package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.ProfessorDAO;
import br.com.schoolManagement.model.Disciplina;
import br.com.schoolManagement.model.Professor;
import br.com.schoolManagement.model.Unidade;
import br.com.schoolManagement.utils.JpaUtil;

public class ProfessorController {
	
// -- Create

	@SuppressWarnings("unused")
	public static void create(Professor professor, long unidade_id, long disciplina_id) {
		EntityManager em = JpaUtil.getEntityManager();
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		
		Unidade unidade = UnidadeController.getById(unidade_id);
		Disciplina disciplina = DisciplinaController.getById(disciplina_id);
		
		professor.setDisciplina(disciplina);
		professor.setUnidade(unidade);
		
		em.getTransaction().begin();
		
		professorDAO.cadastrarDAO(professor);
		
		em.getTransaction().commit();
		em.close();
	}
	public static void createMany(List<Professor> professores, long unidade_id, long disciplina_id) {
		for(Professor professor: professores)
			create(professor, unidade_id, disciplina_id);
	}
	
// -- Read

	public static List<Professor> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		
		em.getTransaction().begin();
		
		List<Professor> professores = professorDAO.findAllDAO();
		
		em.getTransaction().commit();
		em.close();
	
		return professores;
	}
	public static Professor getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		
		em.getTransaction().begin();
		
		Professor professor = professorDAO.getByIdDAO(id);
		
		em.getTransaction().commit();
		em.close();
	
		return professor;
	}
	
	public static void getCursosByUnidade() {
		
	}
	
	public static void getEmpresa() {
	
	}
		
// -- Update
	
	public static void update(long professeor_id, Professor professorNew) {
		EntityManager em = JpaUtil.getEntityManager();
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		
		em.getTransaction().begin();
		
		professorDAO.updateDAO(professeor_id, professorNew);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	
	}

	// -- Delete
	
	public static void deleteByID(long professeor_id) {
		EntityManager em = JpaUtil.getEntityManager();
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		
		Professor professor = getById(professeor_id);
		
		em.getTransaction().begin();
		
		professorDAO.removerDAO(professor);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	public static void deleteAll() {	
		List<Professor> professores = getAll();
		
		for(Professor professor : professores)
			deleteByID(professor.getId());
	}
}
