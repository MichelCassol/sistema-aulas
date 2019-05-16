package br.edu.ifpr.bsi.sistema.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="TB_PRODUTO")
public class Produto extends GenericDomain{

	@Column(length = 30, name = "desc_produto", nullable = false)
	@Basic(optional = false)
	private String descricao;
	
	@Column(name = "quant_produto", nullable = false)
	@Basic(optional = false)
	private Short quantidade;
	
	@Column(name = "preco_produto", nullable = false, scale = 2, precision = 7)
	@Basic(optional = false)
	private BigDecimal preco;
	
	@JoinColumn
	@ManyToOne
	private Fabricante fabricante;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
}
