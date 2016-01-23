package caesweb.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import caesweb.dao.PacienteDao;
import caesweb.model.Paciente;

@LocalBean
@Stateless
public class PacienteBusiness {

	@PersistenceContext
	private EntityManager em;

	private PacienteDao dao;

	@PostConstruct
	private void init() {
		dao = new PacienteDao(em);

	}

	public Paciente salvar(Paciente p) {
		return dao.salvar(p);
	}

	public List<Paciente> pesquisar(String s) {
		return dao.pesquisar(s);
	}
	
	

}
