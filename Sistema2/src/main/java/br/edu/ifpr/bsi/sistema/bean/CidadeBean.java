package br.edu.ifpr.bsi.sistema.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.edu.ifpr.bsi.sistema.dao.CidadeDAO;
import br.edu.ifpr.bsi.sistema.dao.EstadoDAO;
import br.edu.ifpr.bsi.sistema.domain.Cidade;
import br.edu.ifpr.bsi.sistema.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	
	private List<Cidade> cidades;
	private List<Estado> estados;
	private Cidade cidade;
	
	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public void novo() {
		cidade = new Cidade();
		try {
			EstadoDAO dao = new EstadoDAO();
			estados = dao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar recuperar os dados do banco");
			e.printStackTrace();
		}
		
	}

	@PostConstruct
	public void listar() {
		try {
			CidadeDAO dao = new CidadeDAO();
			cidades = dao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar recuperar os dados do banco");
			e.printStackTrace();
		}
	}
	public void salvar() {
		try {

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvarEditar(cidade);
			novo();
			listar();
			Messages.addGlobalInfo("Cidade salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a cidade");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar uma cidade");
			erro.printStackTrace();
		}	
	}
}
