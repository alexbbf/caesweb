package caesweb.view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import caesweb.business.TipoAtendimentoBusiness;
import caesweb.model.TipoAtendimento;

@ManagedBean
@SessionScoped
public class AplicacaoMB {
	
	@EJB
	private TipoAtendimentoBusiness tipoAtendimentoBusiness;
	


	public List<TipoAtendimento> getTipoAtendimentos() {
		return tipoAtendimentoBusiness.listar();
	}

	
	
	
	
	

}
