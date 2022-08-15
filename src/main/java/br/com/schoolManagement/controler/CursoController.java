package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.CursoDAO;
import br.com.schoolManagement.dao.UnidadeDAO;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Unidade;
import br.com.schoolManagement.utils.JpaUtil;

public class CursoController {
	
// -- Create
	
	public static void create(long unidade_id, Curso curso) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		CursoDAO cursoDAO = new CursoDAO(em);
		
		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		
		//curso.setUnidade(unidade);
		
		em.getTransaction().begin();
		
		cursoDAO.cadastrarDAO(curso);
		
		em.getTransaction().commit();
		em.close();
	}
	public static void createMany(long unidade_id, List<Curso> cursos) {
		for(Curso curso: cursos)
			create(unidade_id, curso);
	}
	/*
	public static void createCursoAndManyDisciplinas(long unidade_id, Curso curso, List<Disciplina> disciplinas) {
		curso.setDisciplinas(disciplinas);
		create(unidade_id, curso);
	}
	public static void createDisciplina(long curso_id, long unidade_id, Disciplina disciplina) {	
		Curso curso = getById(curso_id);
		curso.setDisciplina(disciplina);
		
		create(unidade_id, curso);
	}
	public static void createManyDisciplinas(long curso_id, List<Disciplina> disciplinas) {	

	}
	*/
	
// -- Reade
	
	public static Curso getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		
		em.getTransaction().begin();
		
		Curso curso = cursoDAO.getByIdDAO(id);
		
		em.getTransaction().commit();
		em.close();
	
		return curso;
	}
	public static List<Curso> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		
		em.getTransaction().begin();
		
		List<Curso> cursos = cursoDAO.findAllDAO();
		
		em.getTransaction().commit();
		em.close();
		
		return cursos;
	}
	public static void getPeriodoByCurso() {
		
	}
	
	public static void getUnidade() {
	
	}
	
// -- Update
	
	public static void update(long curso_id, Curso cursoNew) {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		
		em.getTransaction().begin();
		
		cursoDAO.updateDAO(curso_id, cursoNew);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	
	}
	
// -- Delete
	

	public static void deleteByID(long curso_id) {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		
		Curso curso = getById(curso_id);
		
		em.getTransaction().begin();
		
		cursoDAO.removerDAO(curso);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	public static void deleteAll() {	
		List<Curso> cursos = getAll();
		
		for(Curso curso : cursos)
			deleteByID(curso.getId());
	}

}
