package br.com.schoolManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Unidade> unidades = new ArrayList<>();
	
	@OneToMany(mappedBy = "curso")
	private List<Periodo> periodos = new ArrayList<>();
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String nome, Unidade unidade) {
		super();
		this.nome = nome;
		this.unidades.add(unidade);
	}

	public Curso(String nome, List<Unidade> unidades) {
		super();
		this.nome = nome;
		this.unidades = unidades;
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
	
	public List<Periodo> getPeriodos() {
		return periodos;
	}
	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	public void setPeriodo(Periodo periodos) {
		this.periodos.add(periodos);
	}
	
	@Override
	public String toString() {
		return  "Id: " + getId() + ", Name: " + getNome() + ", Unidade: " + getUnidades() ;
	}
}
