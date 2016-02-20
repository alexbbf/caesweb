package caesweb.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import caesweb.business.ProfissionalBusiness;
import caesweb.model.Permissao;
import caesweb.model.Profissional;

public class AppUserDetailService implements UserDetailsService {

	@EJB(mappedName = "java:global/caesweb/ProfissionalBusiness")
	private ProfissionalBusiness business;

	@Override
	public UserDetails loadUserByUsername(String cpf)
			throws UsernameNotFoundException {
		Profissional p = business.logar(cpf);
		UsuarioSistema user = null;
		
		if (p != null) {
			user = new UsuarioSistema(p, getGrupos(p));
			
			
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Profissional profissional) {
		List<SimpleGrantedAuthority> grupos = new ArrayList<SimpleGrantedAuthority>();
		for(Permissao perm : profissional.getPermissoes()){
			grupos.add( new SimpleGrantedAuthority(perm.getGrupo().name()));
		}
			
			
		return grupos;
	}

}
