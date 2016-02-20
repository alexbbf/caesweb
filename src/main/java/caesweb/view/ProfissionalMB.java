package caesweb.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import caesweb.business.ProfissionalBusiness;
import caesweb.model.Permissao;
import caesweb.model.Profissional;
import caesweb.util.JsfUtil;

@ManagedBean
@ViewScoped
public class ProfissionalMB {

	@EJB
	private ProfissionalBusiness business;

	private Profissional profissional = new Profissional();

	private String nome;
	
	private Permissao permissaoSelecionada;
	
	private Permissao permissao;

	private List<Profissional> profissionais = new ArrayList<Profissional>();

	public void salvar() {
		profissional.setAtivo(true);
		business.salvar(profissional);
		JsfUtil.showInfoMessage("Dados salvos");
		profissional = new Profissional();
	}
	
	public void excluir(){
		profissional.setAtivo(false);
		business.salvar(profissional);
		JsfUtil.showInfoMessage("Excluido");
	}

	public List<Profissional> pesquisar(String s) {
		return business.pesquisar(s);
	}

	public void buscar() {
		if (nome.length() > 2) {
			profissionais = business.pesquisar(nome);
		} else {
			profissionais = new ArrayList<Profissional>();
		}
	}
	
	public void removerPermissao(){
		profissional.removerPermissao(permissaoSelecionada);
	}
	
	public void adicionarPermissao(){
		profissional.adicionaPermissao(permissao);
		permissao = new Permissao();
	}

	public Permissao getPermissaoSelecionada() {
		return permissaoSelecionada;
	}

	public void setPermissaoSelecionada(Permissao permissaoSelecionada) {
		this.permissaoSelecionada = permissaoSelecionada;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	
	
}
