package br.com.schoolManagement.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.schoolManagement.dao.EmpresaDAO;
import br.com.schoolManagement.dao.UnidadeDAO;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Endereco;
import br.com.schoolManagement.model.Unidade;
import br.com.schoolManagement.utils.JpaUtil;

public class TestApp {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		UnidadeDAO unidadeDAO = new UnidadeDAO(em);

		Empresa empresa01 = new Empresa("EmpresaEmpresa", "12345678901325");

		
		List<Unidade> unidades = new ArrayList<>();
		unidades.addAll(criaUnidades());
		
		Endereco endUnidade03 =new Endereco(
						"Rua do retorno", 
						"123", 
						"Tufao", 
						"Cidade 03", 
						"BH", 
						"61234-765");
		
		Unidade unidade03 = new Unidade("Unidade 03", endUnidade03);
		unidade03.setEmpresa(empresa01);
		
		empresa01.setUnidades(unidades);
		
		em.getTransaction().begin();
		
		empresaDAO.cadastrar(empresa01);
		
		/*
		List<Unidade> empresaPorId = unidadeDAO.consultaPorId(1);
		Empresa empresa = empresaPorId.get(0).getEmpresa();
		unidade03.setEmpresa(empresa);;
		unidadeDAO.cadastrar(unidade03);
		*/
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	private static List<Unidade> criaUnidades() {
		
		List<Unidade> unidades = new ArrayList<>();
		
		Endereco endUnidade01 = new Endereco("Rua A", "12", "Capotis", "Cidade 01", "CE", "64321-123");
		Unidade unidade01 = new Unidade("Unidade 01", endUnidade01);
		
		Endereco endUnidade02 = new Endereco("Rua Barbeiro Barbado", "57", "Alto do Baixo", "Cidade 02", "PR", "67497-765");
		Unidade unidade02 = new Unidade("Unidade 02", endUnidade02);
		
		unidades.add(unidade01);
		unidades.add(unidade02);
			
		return unidades;
	}
}
