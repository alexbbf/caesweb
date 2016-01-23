package caesweb.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import caesweb.dao.ProfissionalDao;
import caesweb.model.Profissional;

@LocalBean
@Stateless
public class ProfissionalBusiness {
	
	@PersistenceContext
	private EntityManager em;
	
	private ProfissionalDao dao;

	@PostConstruct
	private void init() {
		dao = new ProfissionalDao(em);
	}

	public Profissional salvar(Profissional p) {
		return dao.salvar(p);
	}

	public List<Profissional> pesquisar(String s) {
		return dao.pesquisar(s);
	}
	
	
	
	

}
