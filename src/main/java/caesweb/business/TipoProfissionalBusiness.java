package caesweb.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import caesweb.dao.TipoProfissionalDao;
import caesweb.model.TipoProfissional;

@LocalBean
@Stateless
public class TipoProfissionalBusiness {

	@PersistenceContext
	private EntityManager em;

	private TipoProfissionalDao dao;

	@PostConstruct
	private void init() {

		dao = new TipoProfissionalDao(em);

	}

	public List<TipoProfissional> listar() {
		return dao.listar();
	}
	
	

}
