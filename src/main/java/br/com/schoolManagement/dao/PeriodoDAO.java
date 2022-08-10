package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Periodo;

public class PeriodoDAO {

	private EntityManager em;
	
	public PeriodoDAO(EntityManager em) {
		this.em = em;
	}
	
// -- Creat	

	public void cadastrar(Periodo periodo) {
		this.em.persist(periodo);
	}
	
// -- Delete	
	
	public void remover(Periodo periodo) {
		this.em.remove(this.em.merge(periodo));
	}
	
// -- Reade	
	
	@SuppressWarnings("unchecked")
	public List<Periodo> findAll() {
        String query = "select p From Periodo p";
        return this.em.createQuery(query).getResultList();
    }
	
	public Periodo getById(long id) {
		return em.find(Periodo.class, id);
	}
	
// -- Alter

}
