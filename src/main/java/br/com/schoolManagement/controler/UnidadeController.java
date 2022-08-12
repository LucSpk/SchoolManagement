package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.EmpresaDAO;
import br.com.schoolManagement.dao.UnidadeDAO;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Endereco;
import br.com.schoolManagement.model.Professor;
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
		Unidade unidade = getById(unidade_id);
		unidade.setCurso(curso);
					
		create(unidade.getEmpresa().getId(),unidade);
	}
	public static void createManyCurso(long unidade_id, List<Curso> cursos) {
		for(Curso curso: cursos) 
			createCurso(unidade_id, curso);
	}
	
// -- Read
	
	public static Unidade getById(long unidade_id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		
		em.getTransaction().commit();
		em.close();
		
		return unidade;
	}
	public static List<Unidade> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		List<Unidade> unidades = unidadeDAO.findAllDAO();
		
		em.getTransaction().commit();
		em.close();
	
		return unidades;
	}
	public static Empresa getEmpresaByUnidadeId(long unidade_id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		
		Empresa empresa = unidade.getEmpresa();
		
		return empresa;
	}
	public static Endereco getEnderecoByUnidadeId(long unidade_id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		
		Endereco endereco = unidade.getEndereco();
		
		return endereco;
	}
	public static List<Curso> getCursosByUnidadeId(long unidade_id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);

		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		
		List<Curso> cursos = unidade.getCursos();
		
		return cursos;
	}
	public static List<Professor> getProfessorByUnidadeId(long unidade_id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);

		Unidade unidade = unidadeDAO.getByIdDAO(unidade_id);
		
		List<Professor> professores = unidade.getProfessores();
		
		return professores;
	}
	
// -- Update
	
	public static void update(long unidade_id, Unidade unidadeNew) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		unidadeDAO.updateDAO(unidade_id, unidadeNew);
		
		em.getTransaction().commit();
		em.close();
		
	}

	// -- Delete
	
	public static void deleteByID(long unidade_id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		Unidade unidade = getById(unidade_id);
		
		em.getTransaction().begin();
		
		unidadeDAO.removerDAO(unidade);
		
		em.getTransaction().commit();
		em.close();
		
	}
	public static void deleteAll() {	
		List<Unidade> unidades = getAll();
		
		for(Unidade unidade : unidades)
			deleteByID(unidade.getId());
	}

}
