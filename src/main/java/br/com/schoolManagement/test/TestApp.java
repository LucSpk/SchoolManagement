package br.com.schoolManagement.test;

import java.util.ArrayList;
import java.util.List;

import br.com.schoolManagement.controler.CursoController;
import br.com.schoolManagement.controler.UnidadeController;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Endereco;
import br.com.schoolManagement.model.Unidade;

public class TestApp {

	public static void main(String[] args) {
		
		Curso curso = new Curso("Geometria");
		
		CursoController.cadastraCurso(curso, UnidadeController.getUnidadeById(1));
	}
	
	@SuppressWarnings("unused")
	private static List<Unidade> criaUnidades() {
		
		List<Unidade> unidades = new ArrayList<>();
		
		Endereco endUnidade01 = new Endereco("Rua A", "12", "Capotis", "Cidade 01", "CE", "64321-123");
		Unidade unidade01 = new Unidade("Unidade 01", endUnidade01);
		
		Endereco endUnidade02 = new Endereco("Rua Barbeiro Barbado", "57", "Alto do Baixo", "Cidade 02", "PR", "67497-765");
		Unidade unidade02 = new Unidade("Unidade 02", endUnidade02);
		
		Endereco endUnidade03 =new Endereco("Rua do retorno", "123", "Tufao", "Cidade 03", "BH", "61234-765");
		Unidade unidade03 = new Unidade("Unidade 03", endUnidade03);
		
		unidades.add(unidade01);
		unidades.add(unidade02);
		unidades.add(unidade03);
			
		return unidades;
	}
		
}


/*
 * 
 		EntityManager em = JpaUtil.getEntityManager();
		
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);
		
		Endereco endUnidade03 =new Endereco("Rua do retorno", "123", "Tufao", "Cidade 03", "BH", "61234-765");
		Unidade unidade03 = new Unidade("Unidade 03", endUnidade03);
		
		em.getTransaction().begin();
		
		Empresa empresa = empresaDAO.getById(1);
		
		unidade03.setEmpresa(empresa);
		
		unidadeDAO.cadastrar(unidade03);
		
		em.getTransaction().commit();
		em.close(); 
 */
