package caesweb.model;

public enum Grupo {
	
	ROLE_ADMIN("Administrador"),ROLE_PROFISSIONAL("Profissional"),ROLE_AUXILIAR("Auxiliar");
	
	private String label;

	private Grupo(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

}
