package br.com.schoolManagement.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
	
	private Long id;
	private String matricula;
	private String nome;
	private String email;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
		
	public Aluno(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
