package br.edu.ifpr.bsi.sistema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")

@Entity

@Table(name = "TB_FABRICANTE")

public class Fabricante extends GenericDomain {
	@Column(length= 50, name = "fabricante_desc", nullable = false)
	@Basic(optional = false)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
