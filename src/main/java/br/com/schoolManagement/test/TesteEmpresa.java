package br.com.schoolManagement.test;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.EmpresaDAO;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.utils.JpaUtil;

public class TesteEmpresa {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		
		Empresa empresa01 = new Empresa("modelo","12345432198760");
		
		em.getTransaction().begin();
		
		empresaDAO.cadastrar(empresa01);
		
		em.getTransaction().commit();
			
		em.close();
	}
	
}
