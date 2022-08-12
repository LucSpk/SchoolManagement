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
		
		periododDAO.cadastrarDAO(periodo);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void createMany(List<Periodo> periodos) {
		for(Periodo periodo: periodos)
			create(periodo);
	}
	
	
	
// -- Read

	public static List<Periodo> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		PeriodoDAO periododDAO = new PeriodoDAO(em);
		
		em.getTransaction().begin();
		
		List<Periodo> periodos = periododDAO.findAll();
		
		em.getTransaction().commit();
		em.close();
	
		return periodos;
	}
	public static Periodo getById(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		PeriodoDAO periododDAO = new PeriodoDAO(em);
		
		em.getTransaction().begin();
		
		Periodo periodo = periododDAO.getByIdDAO(id);
		
		em.getTransaction().commit();
		em.close();
	
		return periodo;
	}
	
	public static void getCursosByUnidade() {
		
	}
	
	public static void getEmpresa() {
	
	}
	
// -- Edit
	
	public static void update(long periodo_id, Periodo periodoNew) {
		EntityManager em = JpaUtil.getEntityManager();
		PeriodoDAO periodoDAO = new PeriodoDAO(em);
		
		em.getTransaction().begin();
		
		periodoDAO.updateDAO(periodo_id, periodoNew);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	
	}

	// -- Delete
	
	public static void deleteByID(long periodo_id) {
		EntityManager em = JpaUtil.getEntityManager();
		PeriodoDAO periodoDAO = new PeriodoDAO(em);
		
		Periodo periodo = getById(periodo_id);
		
		em.getTransaction().begin();
		
		periodoDAO.removerDAO(periodo);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	public static void deleteAll() {	
		List<Periodo> periodos = getAll();
		
		for(Periodo periodo : periodos)
			deleteByID(periodo.getId());
	}	
}
