package br.com.fiap.model;

import java.util.Date;
import java.util.Calendar;

public class Cliente {
	
	private int id;
	private String user;
	private String senha;
	private int cpf;
	private String nome;
	private Calendar dtNascto;
	private String email;
	private int telefone;
	private Endereco endereco;
		
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDtNascto() {
		return dtNascto;
	}
	public void setDtNascto(Calendar dtNascto) {
		this.dtNascto = dtNascto;
	}
	public void setDtNascto(Date dtNascto) {
		this.dtNascto.setTime(dtNascto);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
	

}
