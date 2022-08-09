package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.UnidadeDAO;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Unidade;
import br.com.schoolManagement.utils.JpaUtil;

public class UnidadeController {

	public static void cadastraUnidade(Unidade unidade, Empresa empresa) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		unidade.setEmpresa(empresa);
		
		em.getTransaction().begin();
		
		unidadeDAO.cadastrar(unidade);
		
		em.getTransaction().commit();
		em.close();
	}

	public static List<Unidade> getUnidades() {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		List<Unidade> unidades = unidadeDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
	
		return unidades;
	
	}
	
	public static Unidade getUnidadeById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		em.getTransaction().begin();
		
		Unidade unidade = unidadeDAO.getById(id);
		
		em.getTransaction().commit();
		em.close();
	
		return unidade;
	}

}
