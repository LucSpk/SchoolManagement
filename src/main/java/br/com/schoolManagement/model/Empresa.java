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
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	@OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
	private List<Unidade> unidades = new ArrayList<>() ;
	
	public Empresa() {

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
		
		for(Unidade unidade : unidades ) {
			unidade.setEmpresa(this);
		}
		
		this.unidades = unidades;
	}
	public void setUnidade(Unidade unidade) {
		unidade.setEmpresa(this);
		this.unidades.add(unidade);
	}
		
	@Override
	public String toString() {
		return  "Id: " + getId() + ", Name: " + getNome() + ", CNPJ: " + getCnpj() ;
	}
}
