package br.edu.ifpr.bsi.sistema.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_USUARIO")
public class usuario extends GenericDomain{
	
	@Column(length = 32, nullable = false)
	private String senha;
	
	@Transient
	private String senhaSemCriptografia;
	
	@Column(length = 1, nullable = false)
	private char tipo;
	
	@JoinColumn(nullable = false)
	@OneToOne
	private Pessoa pessoa;
	
	@Column(nullable = false)
	private boolean ativo;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}

	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
	
	@Transient
	public String getAtivoFormatado() {
		String ativoFormatado = "Desativado";
		if (ativo) {
			ativoFormatado = "Ativado";
		}
		return ativoFormatado;
	}
	
	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;
		if (tipo == 'A') {
			tipoFormatado = "Administrador";
		}else if(tipo == 'G') {
			tipoFormatado = "Gerente";
		}else if (tipo =='C') {
			tipoFormatado = "Cliente";
		}
		return tipoFormatado;
	}

}
