package br.com.schoolManagement.controler;

import java.util.ArrayList;
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
		
		empresaDAO.cadastrar(empresa);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void createMany(List<Empresa> empresas) {		
		for(Empresa empresa : empresas) 
			create(empresa);
	}
	
	public static void createAndUnidades(Empresa empresa, List<Unidade> unidades) {
		empresa.setUnidades(unidades);
		create(empresa);
	}
	
// -- Read
	
	public static List<Empresa> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		em.getTransaction().begin();
		
		List<Empresa> empresas = empresaDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
		
		return empresas;
	}
	
	public static Empresa getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		em.getTransaction().begin();
		
		Empresa empresa = empresaDAO.getById(id);
		
		em.getTransaction().commit();
		em.close();
	
		return empresa;
	}
	
	public static List<Unidade> getUnidadesByEmpresaId(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		List<Unidade> unidades = new ArrayList<>();
		
		em.getTransaction().begin();
		
		unidades = empresaDAO.findUnidadeByEmpresaId(id);
		
		em.getTransaction().commit();
		em.close();
		
		return unidades;
	}
	
// -- Edit

// -- Delete	
}
