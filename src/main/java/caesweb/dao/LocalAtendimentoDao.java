package caesweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import caesweb.model.LocalAtendimento;

public class LocalAtendimentoDao {
	
	private EntityManager em;

	public LocalAtendimentoDao(EntityManager em) {
		this.em = em;
	}

	public List<LocalAtendimento> listar() {
		return em.createQuery("select l from LocalAtendimento l", LocalAtendimento.class).getResultList();
	}
	
	public LocalAtendimento salvar(LocalAtendimento localAtendimento){
		return em.merge(localAtendimento);
	}
	

}
