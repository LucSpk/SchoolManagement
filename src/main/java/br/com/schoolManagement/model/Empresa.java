package br.com.schoolManagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	@OneToMany
	private List<Unidade> unidades;
	
	public Empresa() {
		// TODO Auto-generated constructor stub
	}
	
	public Empresa(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
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
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public List<Unidade> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
		
}
