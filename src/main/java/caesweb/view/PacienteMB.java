package caesweb.view;

import java.util.ArrayList;
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

	private Paciente paciente;

	private String nome;

	private List<Paciente> pacientes = new ArrayList<Paciente>();

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void salvar() {
		paciente.setAtivo(true);
		business.salvar(paciente);
		JsfUtil.showInfoMessage("Dados salvos");
		paciente = new Paciente();
	}
	
	public void excluir() {
		paciente.setAtivo(false);
		business.salvar(paciente);
		JsfUtil.showInfoMessage("Excluido");
		paciente = new Paciente();
	}


	public List<Paciente> pesquisar(String s) {
		return business.pesquisar(s);
	}

	public void buscar() {
		if (nome.length() > 2) {
			pacientes = business.pesquisar(nome);
		} else {
			pacientes = new ArrayList<Paciente>();
		}

	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
