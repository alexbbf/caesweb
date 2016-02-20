package caesweb.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import caesweb.model.Permissao;

@ManagedBean
@ViewScoped
public class PermissaoMB {
	
	private Permissao permissao;
	
	
	
	

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	
	
	

}
