package caesweb.view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import caesweb.business.LocalAtendimentoBusiness;
import caesweb.business.TipoAtendimentoBusiness;
import caesweb.model.Grupo;
import caesweb.model.LocalAtendimento;
import caesweb.model.TipoAtendimento;
import caesweb.util.JsfUtil;

@ManagedBean
@SessionScoped
public class AplicacaoMB {
	
	@EJB
	private TipoAtendimentoBusiness tipoAtendimentoBusiness;
	
	@EJB
	private LocalAtendimentoBusiness localAtendimentoBusiness;
	
	private TipoAtendimento tipoAtendimento = new TipoAtendimento();
	private LocalAtendimento localAtendimento = new LocalAtendimento();
	
	private Grupo[] grupos = Grupo.values();

	public List<TipoAtendimento> getTipoAtendimentos() {
		return tipoAtendimentoBusiness.listar();
	}
	
	public List<LocalAtendimento> getLocaisAtendimento(){
		return localAtendimentoBusiness.listar();
		
	}

	public void salvar() {
		tipoAtendimentoBusiness.salvar(tipoAtendimento);
		JsfUtil.showInfoMessage("Dados salvos");
		tipoAtendimento = new TipoAtendimento();
	}
	
	public void salvarLocalAtendimento() {
		localAtendimentoBusiness.salvar(localAtendimento);
		JsfUtil.showInfoMessage("Dados salvos");
		localAtendimento = new LocalAtendimento();
	}


	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}


	public Grupo[] getGrupos() {
		return grupos;
	}


	public void setGrupos(Grupo[] grupos) {
		this.grupos = grupos;
	}


	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	
	public LocalAtendimento getLocalAtendimento() {
		return localAtendimento;
	}
	
	public void setLocalAtendimento(LocalAtendimento localAtendimento) {
		this.localAtendimento = localAtendimento;
	}


	
	
	
	
	
	

	
	
	
	
	

}
