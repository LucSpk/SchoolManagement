package br.com.schoolManagement.controler;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.PeriodoDAO;
import br.com.schoolManagement.model.Periodo;
import br.com.schoolManagement.utils.JpaUtil;

public class PeriodoController {

// -- Create
	
	public static void create(Periodo periodo) {
		EntityManager em = JpaUtil.getEntityManager();
		PeriodoDAO periododDAO = new PeriodoDAO(em);
		
		em.getTransaction().begin();
		
		periododDAO.cadastrar(periodo);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void createMany(List<Periodo> periodos) {
		for(Periodo periodo: periodos)
			create(periodo);
	}
	
	
	
// -- Read

	public static List<Periodo> getUnidades() {
		EntityManager em = JpaUtil.getEntityManager();
		PeriodoDAO periododDAO = new PeriodoDAO(em);
		
		em.getTransaction().begin();
		
		List<Periodo> periodo = periododDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
	
		return periodo;
	}
	
	public static Periodo getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		PeriodoDAO periododDAO = new PeriodoDAO(em);
		
		em.getTransaction().begin();
		
		Periodo periodo = periododDAO.getById(id);
		
		em.getTransaction().commit();
		em.close();
	
		return periodo;
	}
	
	public static void getCursosByUnidade() {
		
	}
	
	public static void getEmpresa() {
	
	}
	
// -- Edit
	
// -- Delete
	
}
