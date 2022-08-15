package br.com.schoolManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "professores")
	private List<Unidade> unidades = new ArrayList<>();
	
	@OneToOne(mappedBy = "professor")
	private Disciplina disciplina;
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}
	
	public Professor(String nome, List<Unidade> unidades, Disciplina disciplina) {
		super();
		this.nome = nome;
		this.unidades = unidades;
		this.disciplina = disciplina;
	}
	public Professor(String nome, Unidade unidade, Disciplina disciplina) {
		super();
		this.nome = nome;
		this.unidades.add(unidade);
		this.disciplina = disciplina;
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

	public List<Unidade> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
	public void setUnidade(Unidade unidade) {
		this.unidades.add(unidade);
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}
