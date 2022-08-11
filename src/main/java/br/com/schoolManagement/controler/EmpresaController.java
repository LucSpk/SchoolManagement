package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.EmpresaDAO;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Unidade;
import br.com.schoolManagement.utils.JpaUtil;

public class EmpresaController {
	
// -- Create
	
	public static void create(Empresa empresa) {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		em.getTransaction().begin();
		
		empresaDAO.cadastrarDAO(empresa);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	public static void createMany(List<Empresa> empresas) {		
		for(Empresa empresa : empresas) 
			create(empresa);
	}
	public static void createAndUnidade(Empresa empresa, Unidade unidade) {
		empresa.setUnidade(unidade);
		create(empresa);
	}
	public static void createAndManyUnidades(Empresa empresa, List<Unidade> unidades) {
		empresa.setUnidades(unidades);
		create(empresa);
	}
	
// -- Read
	
	public static Empresa getById(long empresa_id) {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		em.getTransaction().begin();
		
		Empresa empresa = empresaDAO.getByIdDAO(empresa_id);
		
		em.getTransaction().commit();
		em.close();
		
		return empresa;
	}
	public static List<Empresa> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		em.getTransaction().begin();
		
		List<Empresa> empresas = empresaDAO.findAllDAO();
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
		
		return empresas;
	}
	public static List<Unidade> getUnidadesByEmpresaId(long empresa_id) {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		Empresa empresa = empresaDAO.getByIdDAO(empresa_id);
		
		List<Unidade> unidades = empresa.getUnidades();
		
		return unidades;
	}
	
// -- update
	
	public static void update(long id, Empresa empresaNew) {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		Empresa empresaOld = getById(id);
		
		em.getTransaction().begin();
		
		empresaDAO.updateDAO(empresaOld.getId(), empresaNew);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}

// -- Delete
	
	public static void deleteByID(long empresa_id) {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		Empresa empresa = getById(empresa_id);
		
		em.getTransaction().begin();
		
		empresaDAO.removerDAO(empresa);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	public static void deleteAll() {	
		List<Empresa> empresas = getAll();
		
		for(Empresa empresa : empresas)
			deleteByID(empresa.getId());
	}

	
}
