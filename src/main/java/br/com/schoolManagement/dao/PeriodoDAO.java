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

	public void cadastrarDAO(Periodo periodo) {
		this.em.persist(periodo);
	}
	
// -- Reade	
	
	public Periodo getByIdDAO(long id) {
		return em.find(Periodo.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Periodo> findAll() {
        String query = "select p From Periodo p";
        return this.em.createQuery(query).getResultList();
    }

// -- Update
	
	public void updateDAO(long id, Periodo periodo) {
		String query = "UPDATE Periodo p "
				+ "SET p.nome = :name "
				+ "WHERE p.id = :id";
		this.em
			.createQuery(query)
			.setParameter("name", periodo.getNome())
			.setParameter("id", id)
			.executeUpdate();	
	}
	
// -- Delete	

	public void removerDAO(Periodo periodo) {
		this.em.remove(this.em.merge(periodo));
	}
	
}
