package caesweb.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import caesweb.business.TipoProfissionalBusiness;
import caesweb.model.TipoProfissional;

@ManagedBean
@ViewScoped
public class TipoProfissionalMB {

	@EJB
	private TipoProfissionalBusiness business;

	private List<TipoProfissional> tipos = new ArrayList<TipoProfissional>();

	@PostConstruct
	private void init() {

		tipos = business.listar();

	}

	public List<TipoProfissional> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoProfissional> tipos) {
		this.tipos = tipos;
	}

}
