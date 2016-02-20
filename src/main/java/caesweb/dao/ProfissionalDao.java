package caesweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import caesweb.model.Profissional;

public class ProfissionalDao {

	private EntityManager em;

	public ProfissionalDao(EntityManager em) {
		this.em = em;
	}

	public Profissional salvar(Profissional p) {
		return em.merge(p);
	}

	public List<Profissional> pesquisar(String s) {
		return em
				.createQuery(
						"SELECT p FROM Profissional p WHERE p.ativo = true and UPPER(p.nome) LIKE UPPER('"
								+ s + "%')", Profissional.class)
				.getResultList();
	}

	public Profissional logar(String usuario) {
		try{
		System.out.println(usuario);
		return em.createQuery(
				"select p from Profissional p where p.usuario = :user and p.ativo = true ",
				Profissional.class).setParameter("user", usuario).getSingleResult();
		}catch(NoResultException nre){
			nre.printStackTrace();
			return null;
		}
	}

}
