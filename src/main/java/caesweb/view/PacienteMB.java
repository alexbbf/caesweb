package caesweb.view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import caesweb.business.PacienteBusiness;
import caesweb.model.Paciente;
import caesweb.util.JsfUtil;

@ManagedBean
@ViewScoped
public class PacienteMB {

	@EJB
	private PacienteBusiness business;

	private Paciente paciente = new Paciente();
	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void salvar() {
		 business.salvar(paciente);
		 JsfUtil.showInfoMessage("Dados salvos");
		 paciente = new Paciente();
	}

	public List<Paciente> pesquisar(String s) {
		return business.pesquisar(s);
	}
	
	
	
	

}
