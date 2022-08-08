package br.com.schoolManagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private List<Unidade> unidade;
	private List<Disciplina> disciplinas;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String nome, List<Unidade> unidade) {
		super();
		this.nome = nome;
		this.unidade = unidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Unidade> getUnidade() {
		return unidade;
	}
	
	public void setUnidade(List<Unidade> unidade) {
		this.unidade = unidade;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
