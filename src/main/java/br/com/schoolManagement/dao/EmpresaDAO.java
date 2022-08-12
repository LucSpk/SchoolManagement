package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Unidade;

public class EmpresaDAO {
	
	private EntityManager em;
	
	public EmpresaDAO(EntityManager em) {
		this.em = em;
	}
	
	
// -- Creat	

	public void cadastrarDAO(Empresa empresa) {
		this.em.persist(empresa);
	}
	
// -- Read	
	
	public Empresa getByIdDAO(long id) {
		return em.find(Empresa.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Empresa> findAllDAO(){
		String query = "SELECT e FROM Empresa e";
		return this.em.createQuery(query).getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Unidade> getUnidadesDAO(long empresa_id) {
		String query = "SELECT e.unidades FROM Empresa e WHERE e.id = :id";
		return this.em.createQuery(query).setParameter("id", empresa_id).getResultList();
	}
	
// -- Update
	
	public void updateDAO(long id, Empresa empresa) {
		String query = "UPDATE Empresa e "
				+ "SET e.nome = :name , "
				+ "e.cnpj = :cnpj "
				+ "WHERE e.id = :id";
		this.em
			.createQuery(query)
			.setParameter("name", empresa.getNome())
			.setParameter("cnpj", empresa.getCnpj())
			.setParameter("id", id)
			.executeUpdate();	
	}
	
// -- Delete

	public void removerDAO(Empresa empresa) {
		this.em.remove(this.em.merge(empresa));
	}
	
}
