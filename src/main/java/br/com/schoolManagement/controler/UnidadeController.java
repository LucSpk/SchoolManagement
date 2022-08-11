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
		
		Empresa empresa = empresaDAO.getByIdDAO(empresa_id);
		
		unidade.setEmpresa(empresa);
		
		em.getTransaction().begin();
		
		unidadeDAO.cadastrarDAO(unidade);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
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

		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		unidade.setCurso(curso);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
			
		create(unidade.getEmpresa().getId(),unidade);
	}
	public static void createManyCurso(long unidade_id, List<Curso> cursos) {
		for(Curso curso: cursos) 
			createCurso(unidade_id, curso);
	}
	
// -- Read
	
	public static Unidade getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		Unidade unidade = unidadeDAO.getByIdDAO(id);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	
		return unidade;
	}
	public static List<Unidade> getUnidades() {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		List<Unidade> unidades = unidadeDAO.findAllDAO();
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	
		return unidades;
	}
	public static Empresa getEmpresa(long unidade_id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		
		em.getTransaction().begin();
		
		Empresa empresa = unidade.getEmpresa();
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
		
		return empresa;
	}
	
	public static List<Curso> getCursosByUnidade() {
		return null;
	}
	
// -- Update
	
// -- Delete

}
