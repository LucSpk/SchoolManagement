package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.CursoDAO;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Unidade;
import br.com.schoolManagement.utils.JpaUtil;

public class CursoController {
	
	public static void cadastraCurso(Curso curso, Unidade unidade) {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		
		curso.setUnidade(unidade);
		
		em.getTransaction().begin();
		
		cursoDAO.cadastrar(curso);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Curso> getCursos() {
		EntityManager em = JpaUtil.getEntityManager();
		CursoDAO cursoDAO = new CursoDAO(em);
		
		em.getTransaction().begin();
		
		List<Curso> cursos = cursoDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
		
		return cursos;
	}
}
