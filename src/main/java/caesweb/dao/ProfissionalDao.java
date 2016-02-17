package caesweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import caesweb.model.Profissional;

public class ProfissionalDao {

	private EntityManager em;

	public ProfissionalDao(EntityManager em) {
		this.em = em;
	}
	
	public Profissional salvar(Profissional p){
		return em.merge(p);
	}
	
	public List<Profissional> pesquisar(String s) {
		return em.createQuery(
				"SELECT p FROM Profissional p WHERE p.ativo = true and UPPER(p.nome) LIKE UPPER('"
						+ s + "%')", Profissional.class).getResultList();
	}
	
	
}
