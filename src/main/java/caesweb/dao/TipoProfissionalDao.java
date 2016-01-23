package caesweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import caesweb.model.TipoProfissional;

public class TipoProfissionalDao {
	
	private EntityManager em;

	public TipoProfissionalDao(EntityManager em) {
		this.em = em;
	}
	
	public List<TipoProfissional> listar(){
		return em.createQuery("select t from TipoProfissional t", TipoProfissional.class).getResultList();
	}

}
