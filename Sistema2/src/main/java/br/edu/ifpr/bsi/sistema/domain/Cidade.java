package br.edu.ifpr.bsi.sistema.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_CIDADE")
public class Cidade extends GenericDomain {
	
	@Column(length = 30, name = "nome_estado", nullable = false)
	private String nome;
	
	@JoinColumn
	@ManyToOne
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
