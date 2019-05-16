package br.edu.ifpr.bsi.sistema.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_PESSOA")
public class Pessoa extends GenericDomain{
	
	@Column(length = 50, name = "nome_pessoa", nullable = false)
	private String nome;
	@Column(length = 50,name = "rg_pessoa", nullable = false)
	private String rg;
	@Column(length = 50,name = "cpf_pessoa",nullable = false)
	private String cpf;
	@JoinColumn
	@ManyToOne
	private Estado estado;
	@JoinColumn
	@ManyToOne
	private Cidade cidade;
	@Column(length = 50,name = "rua_pessoa",nullable = false)
	private String rua;
	@Column(length = 50,name = "numero_pessoa",nullable = false)
	private String numero;
	@Column(length = 50,name = "bairro_pessoa",nullable = false)
	private String bairro;
	@Column(length = 50,name = "cep_pessoa",nullable = false)
	private String cep;
	@Column(length = 50,name = "complemento_pessoa")
	private String complemento;
	@Column(length = 50,name = "telefone_pessoa")
	private String telefone;
	@Column(length = 50,name = "celular_pessoa")
	private String celular;
	@Column(length = 50,name = "email_pessoa")
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
