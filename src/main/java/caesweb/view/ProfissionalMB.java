package caesweb.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import caesweb.business.ProfissionalBusiness;
import caesweb.model.Profissional;
import caesweb.util.JsfUtil;

@ManagedBean
@ViewScoped
public class ProfissionalMB {

	@EJB
	private ProfissionalBusiness business;

	private Profissional profissional = new Profissional();

	private List<Profissional> profissionais = new ArrayList<Profissional>();

	
	public void salvar() {
		business.salvar(profissional);
		JsfUtil.showInfoMessage("Dados salvos");
		profissional = new Profissional();
	}

	public List<Profissional> pesquisar(String s) {
		return  business.pesquisar(s);
	}
	
	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}


}
