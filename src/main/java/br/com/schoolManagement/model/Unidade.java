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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "unidades")
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 255, nullable = false)
	private String nome;
	
	@ManyToOne
	private Empresa empresa;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "unidade")
	private List<ReferenciaDoCurso> referenciaDoCursos = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Professor> professores = new ArrayList<>();
	
	public Unidade() {
		
	}

	public Unidade(String nome, Endereco endereco, Empresa empresa) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.empresa = empresa;
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
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<ReferenciaDoCurso> getCursos() {
		return referenciaDoCursos;
	}
	public void setCursos(List<ReferenciaDoCurso> cursos) {	
		this.referenciaDoCursos = cursos;
	}
	public void setCurso(ReferenciaDoCurso curso) {
		this.referenciaDoCursos.add(curso);
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	public void setProfessore(Professor professore) {
		this.professores.add(professore);
	}
	
	@Override
	public String toString() {
		return  "Id: " + getId() + ", Name: " + getNome() + ", Empresa: " + getEmpresa().getNome() ;
	}

}
