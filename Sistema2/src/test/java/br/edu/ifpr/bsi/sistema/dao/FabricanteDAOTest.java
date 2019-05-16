package br.edu.ifpr.bsi.sistema.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.ifpr.bsi.sistema.domain.Fabricante;

public class FabricanteDAOTest {
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Coca-cola");
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fabricante);
	}
	
	@Test
	public void excluir() {
		Fabricante fabricante = new Fabricante();
		FabricanteDAO dao = new FabricanteDAO();
		
		fabricante = dao.buscar(1L);
		
		System.out.println("Fabricante: "+fabricante.getDescricao());
		
		dao.excluir(fabricante);
	}
}
