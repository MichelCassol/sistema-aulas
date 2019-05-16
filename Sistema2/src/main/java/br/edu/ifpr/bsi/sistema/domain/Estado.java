package br.edu.ifpr.bsi.sistema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//anotacoes
//define a classe como tabela (entidade)
@SuppressWarnings("serial")
@Entity
//permite alterar o nome da tabela
@Table(name ="TB_ESTADO")
public class Estado extends GenericDomain {
	
	@Column(length=20, name ="estado_nome", nullable=false)
	//verifica se um atributo e nulo no nivel do objeto
	@Basic(optional=false)
	private String nome;
	
	@Column (length=2, name="estado_sigla", nullable=false)
	@Basic(optional=false)
	private String sigla;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	

}
