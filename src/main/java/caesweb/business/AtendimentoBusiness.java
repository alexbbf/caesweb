package caesweb.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import caesweb.dao.AtendimentoDao;
import caesweb.model.Atendimento;

@LocalBean
@Stateless
public class AtendimentoBusiness {
	
	@PersistenceContext
	private EntityManager em;
	
	private AtendimentoDao dao;
	
	@PostConstruct
	private void init() {
		
		dao = new AtendimentoDao(em);

	}

	public Atendimento salvar(Atendimento atendimento) {
		return dao.salvar(atendimento);
	}

	public List<Atendimento> listar() {
		return dao.listar();
	}
	
	
	
	

}
