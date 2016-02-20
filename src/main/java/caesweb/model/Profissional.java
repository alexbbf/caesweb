package caesweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("profissional")
public class Profissional extends Pessoa {

	private String registroConselho;

	private String especialidade;

	private String senha;

	private String usuario;

	@OneToMany(mappedBy = "profissional", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Permissao> permissoes;

	@ManyToOne
	private TipoProfissional tipoProfissional;
	
	public void adicionaPermissao(Permissao p){
		if(permissoes == null){
			permissoes = new ArrayList<Permissao>();
		}
		p.setProfissional(this);
		permissoes.add(p);
	}
	
	public void removerPermissao(Permissao p){
		permissoes.remove(p);
	}

	public String getRegistroConselho() {
		return registroConselho;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public void setRegistroConselho(String registroConselho) {
		this.registroConselho = registroConselho;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TipoProfissional getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(TipoProfissional tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime
				* result
				+ ((registroConselho == null) ? 0 : registroConselho.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime
				* result
				+ ((tipoProfissional == null) ? 0 : tipoProfissional.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (registroConselho == null) {
			if (other.registroConselho != null)
				return false;
		} else if (!registroConselho.equals(other.registroConselho))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (tipoProfissional == null) {
			if (other.tipoProfissional != null)
				return false;
		} else if (!tipoProfissional.equals(other.tipoProfissional))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
