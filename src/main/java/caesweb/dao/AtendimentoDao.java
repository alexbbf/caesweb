package caesweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import caesweb.model.Atendimento;

public class AtendimentoDao {

	EntityManager em;

	public AtendimentoDao(EntityManager em) {
		this.em = em;
	}
	
	public Atendimento salvar(Atendimento atendimento){
		return em.merge(atendimento);
	}
	
	public List<Atendimento> listar(){
		return em.createQuery("SELECT a FROM Atendimento a", Atendimento.class).getResultList();
	}

}
