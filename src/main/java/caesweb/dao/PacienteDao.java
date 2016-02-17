package caesweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import caesweb.model.Paciente;



public class PacienteDao {
	
	private EntityManager em;

	public PacienteDao(EntityManager em) {
		this.em = em;
	}
	
	public Paciente salvar(Paciente p){
		return em.merge(p);
	}
	
	public List<Paciente> pesquisar(String s) {
		return em.createQuery(
				"SELECT p FROM Paciente p WHERE p.ativo = true and UPPER(p.nome) LIKE UPPER('"
						+ s + "%')", Paciente.class).getResultList();
	}
	

}
