package br.com.schoolManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
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
	@JoinTable(name = "referencia_curso")
	private List<Unidade> unidades = new ArrayList<>();
	
	@OneToMany(mappedBy = "curso")
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@ManyToMany(mappedBy = "cursos")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String nome) {
		super();
		this.nome = nome;
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
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public void setAluno(Aluno aluno) {
		this.alunos.add(aluno);	
	}	
	
	@Override
	public String toString() {
		return  "Id: " + getId() + ", Name: " + getNome() + ", Unidade: " + getUnidades() + "\n";
	}
}
