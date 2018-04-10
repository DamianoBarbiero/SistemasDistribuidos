package br.com.proj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Choco {

	public static final String QUERY_ALL = "Choco.All";
	
	@Id
	@GeneratedValue
	private int codigo;
	
	private String nome;
	private String tipo;
	private double porcentcacau;
	
	public Choco() {
	}

	public Choco(int codigo, String nome, String tipo, double porcentcacau) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.setPorcentcacau(porcentcacau);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPorcentcacau() {
		return porcentcacau;
	}

	public void setPorcentcacau(double porcentcacau2) {
		this.porcentcacau = porcentcacau2;
	}
	
}
