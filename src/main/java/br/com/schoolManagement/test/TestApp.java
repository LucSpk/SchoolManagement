package br.com.schoolManagement.test;

import java.util.ArrayList;
import java.util.List;

import br.com.schoolManagement.controler.EmpresaController;
import br.com.schoolManagement.controler.Refresh;
import br.com.schoolManagement.model.Aluno;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Disciplina;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Endereco;
import br.com.schoolManagement.model.Periodo;
import br.com.schoolManagement.model.Professor;
import br.com.schoolManagement.model.Unidade;

public class TestApp {

	public static void main(String[] args) {
		
		Refresh.run();
		
	}	
	
	@SuppressWarnings("unused")
	private void testes() {
		Empresa empresa = new Empresa("Empresa numro 03","12543498673214");
		Endereco endereco = new Endereco();
		Unidade unidade = new Unidade("Faculdade de Tecnologia das Capivaras ", endereco, empresa);
		Curso curso = new Curso();
		Disciplina disciplina = new Disciplina();
		Periodo periodo = new Periodo();
		Professor professor = new Professor();
		Aluno aluno = new Aluno();
		
		List<Aluno> alunos = new ArrayList<>();
		List<Professor> professores = new ArrayList<>();
		List<Professor> professores2 = new ArrayList<>();
		List<Professor> professores3 = new ArrayList<>();
		List<Periodo> periodos = new ArrayList<>();
		List<Disciplina> disciplinas = new ArrayList<>();
		List<Curso> cursos = new ArrayList<>();
		List<Unidade> unidades = new ArrayList<>();
		
		EmpresaController.deleteByID(1);
	}
}