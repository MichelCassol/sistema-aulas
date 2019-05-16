package br.edu.ifpr.bsi.sistema.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import br.edu.ifpr.bsi.sistema.dao.EstadoDAO;
import br.edu.ifpr.bsi.sistema.domain.Estado;
import br.edu.ifpr.bsi.sistema.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean  implements Serializable{
	
	private Estado estado;
	private List<Estado> estados;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		
		try {
			EstadoDAO dao = new EstadoDAO();
			dao.salvarEditar(estado);
			novo();
			listar();
			Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			e.printStackTrace();
		}

		/*String texto = "Teste de controle";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null,message);*/
		
		//Messages.addGlobalError("Teste");
	}
	
	@PostConstruct
	public void listar() {
		try {
			EstadoDAO dao = new EstadoDAO();
			
			estados = dao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar recuperar os dados do banco");
			e.printStackTrace();
		}
	}
	
	public void excluir (ActionEvent evento){
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		try {

			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			listar();
			Messages.addGlobalInfo("Registro excluído com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o registro");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
	}
	
	public void imprimir() {
		try {
			//caminho de acesso ao relatório
			String caminho = Faces.getRealPath("/reports/ReportEstado.jasper");
			
			Map<String, Object> parametros = new HashMap<>();

			//cria a conexão
			Connection conexao = HibernateUtil.getConexao();

			//Criação do relatório
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			
			JasperPrintManager.printReport(relatorio, true);
			
			//JasperViewer.viewReport(relatorio,true);
			
		} catch (JRException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			e.printStackTrace();
		}
	}
	
}
