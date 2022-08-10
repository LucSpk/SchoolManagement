package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.EmpresaDAO;
import br.com.schoolManagement.dao.UnidadeDAO;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Unidade;
import br.com.schoolManagement.utils.JpaUtil;

public class UnidadeController {

// -- Create
	
	public static void create(long empresa_id, Unidade unidade) {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		Empresa empresa = empresaDAO.getById(empresa_id);
		
		unidade.setEmpresa(empresa);
		
		em.getTransaction().begin();
		
		unidadeDAO.cadastrar(unidade);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void createMany(long empresa_id, List<Unidade> unidades) {
		for(Unidade unidade: unidades) 
			create(empresa_id, unidade);	
	}
	
	public static void createUnidadeAndCurso(long empresa_id, Unidade unidade, Curso curso) {	
		unidade.setCurso(curso);
		create(empresa_id, unidade);
	}
	
	public static void createUnidadeAndManyCursos(long empresa_id, Unidade unidade, List<Curso> cursos) {	
		unidade.setCursos(cursos);
		create(empresa_id, unidade);
	}
	
	public static void createCurso(long unidade_id, Curso curso) {	
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();

		Unidade unidade = unidadeDAO.getById(unidade_id);
		unidade.setCurso(curso);
		
		em.getTransaction().commit();
		em.close();
			
		create(unidade.getEmpresa().getId(),unidade);
	}
	
	public static void createManyCurso(long unidade_id, List<Curso> cursos) {
		for(Curso curso: cursos) 
			createCurso(unidade_id, curso);
	}
	
// -- Read

	public static List<Unidade> getUnidades() {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		List<Unidade> unidades = unidadeDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
	
		return unidades;
	}
	
	public static Unidade getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		Unidade unidade = unidadeDAO.getById(id);
		
		em.getTransaction().commit();
		em.close();
	
		return unidade;
	}
	
	public static void getCursosByUnidade() {
		
	}
	
	public static void getEmpresa() {
	
	}
	
// -- Edit
	
// -- Delete

}
