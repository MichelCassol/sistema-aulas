package br.edu.ifpr.bsi.sistema.dao;

import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import br.edu.ifpr.bsi.sistema.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

//Uso do conceito generics<>
//O elemento generico pode se converter em outro tipo
// de obejto posteriormente

/*todo metodo que faz uma consulta ao banco e não faz alteração, nao precisa de transação*/ 

public class GenericDAO <Entidade>{
	
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade) {
		
		//Abertura de comunicação com a base de dados
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		//garante a integridade da ação
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			//Confirma a transação
			transacao.commit();
			
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
				throw e;
			}
		}finally {
			sessao.close();
		}
		
	}
	
	public void salvarEditar(Entidade entidade) {
		
		//Abertura de comunicação com a base de dados
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		//garante a integridade da ação
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			//Confirma a transação
			transacao.commit();
			
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
				throw e;
			}
		}finally {
			sessao.close();
		}
		
	}

	public void excluir(Entidade entidade) {
		
		//Abertura de comunicação com a base de dados
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		//garante a integridade da ação
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			//Confirma a transação
			transacao.commit();
			
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
				throw e;
			}
		}finally {
			sessao.close();
		}
		
	}
	
	public void editar(Entidade entidade) {
		
		//Abertura de comunicação com a base de dados
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		//garante a integridade da ação
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			//Confirma a transação
			transacao.commit();
			
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
				throw e;
			}
		}finally {
			sessao.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listarOrdenado(String campoOrdenacao) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			//critério de ordenação
			consulta.addOrder(Order.asc(campoOrdenacao));
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}

}
