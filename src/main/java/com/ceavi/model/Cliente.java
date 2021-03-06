package com.ceavi.model;


public class Cliente {

	
	private long id;
	
	private String nome;
	
	private String cpf;
	
	private String logradouro;
	
	private String numero;
	
	private String bairro;
	
	private String cidade;
	
	private String cep;
	
	private String estado;
	
	private double descontoPorCliente;
	
	

	public double getDescontoPorCliente() {
		return descontoPorCliente;
	}

	public void setDescontoPorCliente(double descontoPorCliente) {
		this.descontoPorCliente = descontoPorCliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
