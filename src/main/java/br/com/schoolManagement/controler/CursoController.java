package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.CursoDAO;
import br.com.schoolManagement.dao.UnidadeDAO;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Disciplina;
import br.com.schoolManagement.model.Periodo;
import br.com.schoolManagement.model.Unidade;
import br.com.schoolManagement.utils.JpaUtil;

public class CursoController {
	
// -- Create
	
	public static void create(long unidade_id, Curso curso) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		CursoDAO cursoDAO = new CursoDAO(em);
		
		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		
		curso.setUnidade(unidade);
		
		em.getTransaction().begin();
		
		cursoDAO.cadastrar(curso);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void createMany(long unidade_id, List<Curso> cursos) {
		for(Curso curso: cursos)
			create(unidade_id, curso);
	}
	
	public static void createCursoAndDisciplinas(long unidade_id, Curso curso, List<Disciplina> disciplinas) {
		curso.setDisciplinas(disciplinas);
		create(unidade_id, curso);
	}
	
	public static void createDisciplina(long curso_id, Disciplina disciplina) {	
		
	}
	
	public static void createManyDisciplinas(long curso_id, List<Periodo> periodos) {	

	}
	
// -- Reade
	
	public static List<Curso> getCursos() {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		
		em.getTransaction().begin();
		
		List<Curso> cursos = cursoDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
		
		return cursos;
	}
	
	public static Curso getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		
		em.getTransaction().begin();
		
		Curso curso = cursoDAO.getById(id);
		
		em.getTransaction().commit();
		em.close();
	
		return curso;
	}
	
	public static void getPeriodoByCurso() {
		
	}
	
	public static void getUnidade() {
	
	}
	
	// -- Edite
	
	// -- Alter

}
