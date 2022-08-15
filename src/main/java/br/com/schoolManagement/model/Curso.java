package br.com.schoolManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
	private ReferenciaDoCurso referenciaCurso;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String nome) {
		super();
		this.nome = nome;
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

	public ReferenciaDoCurso getReferenciaCurso() {
		return referenciaCurso;
	}
	public void setReferenciaCurso(ReferenciaDoCurso referenciaCurso) {
		this.referenciaCurso = referenciaCurso;
	}
	
	@Override
	public String toString() {
		return  "Id: " + getId() + ", Name: " + getNome() + ", Unidade: ";
	}

}
