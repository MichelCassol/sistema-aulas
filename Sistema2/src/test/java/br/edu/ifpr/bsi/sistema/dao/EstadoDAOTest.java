package br.edu.ifpr.bsi.sistema.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.edu.ifpr.bsi.sistema.domain.Estado;

public class EstadoDAOTest {
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setCodigo(5L);
		estado.setNome("Acre");
		estado.setSigla("AC");
		
		EstadoDAO dao = new EstadoDAO();
		dao.salvar(estado);
	}
	
	@Test
	public void excluir() {
		Estado estado = new Estado();
		EstadoDAO dao = new EstadoDAO();
		
		estado = dao.buscar(1L);
		
		System.out.println("Estado: "+estado.getNome());
		dao.excluir(estado);
	}
}
