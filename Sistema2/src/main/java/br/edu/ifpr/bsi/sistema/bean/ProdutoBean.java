package br.edu.ifpr.bsi.sistema.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import br.edu.ifpr.bsi.sistema.dao.ProdutoDAO;
import br.edu.ifpr.bsi.sistema.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	
	private Produto produto;
	private List<Produto> produtos;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void novo() {
		produto = new Produto();
	}
	
	public void salvar() {
		try {
			
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvarEditar(produto);
			novo();
			listar();
			
			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao tentar salvar o produto");
		}
	}
	
	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			
			produtos = dao.listar();
			
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar recuperar os dados do banco");
		}
	}

}
