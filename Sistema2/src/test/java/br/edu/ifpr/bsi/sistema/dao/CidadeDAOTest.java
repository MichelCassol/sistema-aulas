package br.edu.ifpr.bsi.sistema.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.ifpr.bsi.sistema.domain.Cidade;
import br.edu.ifpr.bsi.sistema.domain.Estado;

public class CidadeDAOTest {
	
	@Ignore
	public void salvar() {
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		EstadoDAO dao = new EstadoDAO();
		
		estado = dao.buscar(1L);
		
		cidade.setNome("Palmas");
		cidade.setEstado(estado);
		
		CidadeDAO dao2 = new CidadeDAO();
		
		dao2.salvar(cidade);
	}
	
	@Test
	public void excluir() {
		Cidade cidade = new Cidade();
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		cidade = cidadeDAO.buscar(1L);
		
		System.out.println("Cidade: "+cidade.getNome());
		
		cidadeDAO.excluir(cidade);
	}
}
