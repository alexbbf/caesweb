package caesweb.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import caesweb.model.Profissional;


public class UsuarioSistema extends User{

	

	private static final long serialVersionUID = -3738762746335137875L;
	private Profissional p;
	
	public UsuarioSistema(Profissional p,
			Collection<? extends GrantedAuthority> authorities) {
		super(p.getUsuario(),p.getSenha(), authorities);
		this.p = p;
	}
	
	public Profissional getP() {
		return p;
	}

}
