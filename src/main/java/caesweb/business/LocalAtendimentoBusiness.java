package caesweb.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import caesweb.dao.LocalAtendimentoDao;
import caesweb.model.LocalAtendimento;

@LocalBean
@Stateless
public class LocalAtendimentoBusiness {
	
	@PersistenceContext
	private EntityManager em;
	
	private LocalAtendimentoDao dao;
	
	@PostConstruct
	private void init() {
		dao = new LocalAtendimentoDao(em);

	}
	
	public List<LocalAtendimento> listar(){
		return dao.listar();
	}
	
	public LocalAtendimento salvar(LocalAtendimento localAtendimento){
		return dao.salvar(localAtendimento);
	}

}
