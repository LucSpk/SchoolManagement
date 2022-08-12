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
@Table(name = "periodos")
public class Periodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL)
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@ManyToMany(mappedBy = "periodos")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Periodo() {

	}
	
	public Periodo(String nome) {
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
		return getNome();
	}
}
