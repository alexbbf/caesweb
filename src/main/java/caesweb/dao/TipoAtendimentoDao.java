package caesweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import caesweb.model.TipoAtendimento;

public class TipoAtendimentoDao {
	
	EntityManager em;

	public TipoAtendimentoDao(EntityManager em) {
		this.em = em;
	}
	
	public List<TipoAtendimento> listar(){
		return em.createQuery("select t from TipoAtendimento t", TipoAtendimento.class).getResultList();
	}
	
	

}
