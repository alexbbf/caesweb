package caesweb.view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import caesweb.business.TipoAtendimentoBusiness;
import caesweb.model.Grupo;
import caesweb.model.TipoAtendimento;
import caesweb.util.JsfUtil;

@ManagedBean
@SessionScoped
public class AplicacaoMB {
	
	@EJB
	private TipoAtendimentoBusiness tipoAtendimentoBusiness;
	
	TipoAtendimento tipoAtendimento = new TipoAtendimento();
	
	private Grupo[] grupos = Grupo.values();

	public List<TipoAtendimento> getTipoAtendimentos() {
		return tipoAtendimentoBusiness.listar();
	}


	public void salvar() {
		tipoAtendimentoBusiness.salvar(tipoAtendimento);
		JsfUtil.showInfoMessage("Dados salvos");
		tipoAtendimento = new TipoAtendimento();
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
	
	
	
	

	
	
	
	
	

}
