package caesweb.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import caesweb.dao.TipoAtendimentoDao;
import caesweb.model.TipoAtendimento;

@LocalBean
@Stateless
public class TipoAtendimentoBusiness {
	
	@PersistenceContext
	private EntityManager em;
	
	private TipoAtendimentoDao dao;
	
	@PostConstruct
	private void init() {
		dao = new TipoAtendimentoDao(em);
	}

	public List<TipoAtendimento> listar() {
		return dao.listar();
	}
	
	

}
