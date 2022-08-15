package br.com.schoolManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cpf;
	
	@ManyToMany
	private List<ReferenciaDoCurso> referenciaDoCurso = new ArrayList<>();
	
	@ManyToMany
	private List<Periodo> periodos = new ArrayList<>();
	
	public Aluno() {

	}
	
	public Aluno(String nome, String cpf, ReferenciaDoCurso referenciaDoCurso) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.referenciaDoCurso.add(referenciaDoCurso);
	}
	
	public Aluno(String nome, String cpf, List<ReferenciaDoCurso> referenciaDoCurso) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.referenciaDoCurso = referenciaDoCurso;
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

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}
	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodos.add(periodo);
	}

}
