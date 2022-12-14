package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.CursoDAO;
import br.com.schoolManagement.dao.DisciplinaDAO;
import br.com.schoolManagement.dao.PeriodoDAO;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Disciplina;
import br.com.schoolManagement.model.Periodo;
import br.com.schoolManagement.utils.JpaUtil;

public class DisciplinaController {

	// -- Create
	
	public static void create(long curso_id, Disciplina disciplina, long periodo_id) {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO(em);
		PeriodoDAO periododDAO = new PeriodoDAO(em);
		
		Curso curso = cursoDAO.getByIdDAO(curso_id);
		Periodo periodo = periododDAO.getByIdDAO(periodo_id);
		
		disciplina.setCurso(curso);
		disciplina.setPeriodo(periodo);
		
		em.getTransaction().begin();
		
		disciplinaDAO.cadastrar(disciplina);
		
		em.getTransaction().commit();
		em.close();
	}	
	public static void createMany(long curso_id, List<Disciplina> disciplinas, long periodo_id) {
		for(Disciplina disciplina: disciplinas)
			create(curso_id, disciplina, periodo_id);
	}
	public static void createDisciplinaAndPeriodo(long curso_id, List<Disciplina> disciplinas, Periodo periodo) {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO(em);
		
		Curso curso = cursoDAO.getByIdDAO(curso_id);
		
		em.getTransaction().begin();
		
		for(Disciplina disciplina : disciplinas) {
			disciplina.setCurso(curso);
			disciplina.setPeriodo(periodo);
			
			disciplinaDAO.cadastrar(disciplina);
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
// -- Read

	public static List<Disciplina> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO(em);
		
		em.getTransaction().begin();
		
		List<Disciplina> disciplinas = disciplinaDAO.findAllDAO();
		
		em.getTransaction().commit();
		em.close();
		
		return disciplinas;
	}
	public static Disciplina getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO(em);
		
		em.getTransaction().begin();
		
		Disciplina disciplina = disciplinaDAO.getById(id);
		
		em.getTransaction().commit();
		em.close();
		
		return disciplina;
	}
	public static void getCursosByUnidade() {
		
	}
	public static void getEmpresa() {
	
	}
		
	// -- Update
		
	public static void update(long disciplina_id, Disciplina disciplinaNew) {
		EntityManager em = JpaUtil.getEntityManager();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO(em);
		
		em.getTransaction().begin();
		
		disciplinaDAO.updateDAO(disciplina_id, disciplinaNew);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	
	}
		
	// -- Delete
	
	public static void deleteByID(long disciplina_id) {
		EntityManager em = JpaUtil.getEntityManager();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO(em);
		
		Disciplina disciplina = getById(disciplina_id);
		
		em.getTransaction().begin();
		
		disciplinaDAO.removerDAO(disciplina);
		
		em.getTransaction().commit();
		em.close();

	}
	public static void deleteAll() {	
		List<Disciplina> disciplinas = getAll();
		
		for(Disciplina disciplina : disciplinas)
			deleteByID(disciplina.getId());
	}
}
