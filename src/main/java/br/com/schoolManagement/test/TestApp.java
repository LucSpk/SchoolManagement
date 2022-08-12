package br.com.schoolManagement.test;

import java.util.ArrayList;
import java.util.List;

import br.com.schoolManagement.controler.ProfessorController;
import br.com.schoolManagement.model.Aluno;
import br.com.schoolManagement.model.Curso;
import br.com.schoolManagement.model.Disciplina;
import br.com.schoolManagement.model.Empresa;
import br.com.schoolManagement.model.Endereco;
import br.com.schoolManagement.model.Periodo;
import br.com.schoolManagement.model.Professor;
import br.com.schoolManagement.model.Unidade;

public class TestApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
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
		
		//Disciplina disciplina01 = new Disciplina("Logica de Programacao");
		//Disciplina disciplina02 = new Disciplina("Algoritmo");
		//Disciplina disciplina03 = new Disciplina("Logica de Programacao");
		
		//DisciplinaController.create(45, disciplina01, 1);		
		//DisciplinaController.create(45, disciplina02, 1);		
		//DisciplinaController.create(46, disciplina03, 1);		
		
		ProfessorController.create(new Professor("Bruna"), 3, 1);
		ProfessorController.create(new Professor("Thiago"), 3, 2);
		ProfessorController.create(new Professor("Felipe"), 3, 3);
		
	}	
}