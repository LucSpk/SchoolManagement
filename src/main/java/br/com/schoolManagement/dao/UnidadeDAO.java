package br.com.schoolManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Unidade;

public class UnidadeDAO {

	private EntityManager em;
	
	public UnidadeDAO(EntityManager em) {
		this.em = em;
	}

// -- Creat	

	public void cadastrarDAO(Unidade unidade) {
		this.em.persist(unidade);
	}
	
// -- Read	

	public Unidade getByIdDAO(long id) {
		return em.find(Unidade.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Unidade> findAllDAO(){
		String query = "select u From Unidade u";
		return this.em.createQuery(query).getResultList();
	}
	public List<Curso> findCursosByUnidadeIdDAO(long id) {
		String query = "select c From Cursos c WHERE c.unidades.id = :id";
        return this.em
        		.createQuery(query, Curso.class)
        		.setParameter("id", id)
        		.getResultList();
	}
	
	public Empresa getEmpresa(long id) {
		return null;
	}
	
// -- Update	

// -- Delete	

	public void remover(Unidade unidade) {
		this.em.remove(this.em.merge(unidade));
	}
}
