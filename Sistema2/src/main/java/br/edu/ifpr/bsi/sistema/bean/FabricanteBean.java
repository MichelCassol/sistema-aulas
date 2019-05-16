package br.edu.ifpr.bsi.sistema.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.edu.ifpr.bsi.sistema.dao.FabricanteDAO;
import br.edu.ifpr.bsi.sistema.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable{
	
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public void novo() {
		fabricante = new Fabricante();
	}
	
	public void salvar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			
			dao.salvarEditar(fabricante);
			novo();
			listar();
			
			Messages.addGlobalInfo("Fabricante salvo com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalFatal("Erro ao tentar salvar o fabricante");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			
			fabricantes = dao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar recuperar os dados do banco");
			e.printStackTrace();
		}
	}
	
	public void excluir (ActionEvent evento){
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
		try {

			FabricanteDAO DAO = new FabricanteDAO();
			DAO.excluir(fabricante);
			listar();
			Messages.addGlobalInfo("Registro excluído com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o registro");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
	}
	

}
