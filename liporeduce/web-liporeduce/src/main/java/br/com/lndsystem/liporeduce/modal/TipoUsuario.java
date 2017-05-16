package br.com.lndsystem.liporeduce.modal;

public enum TipoUsuario {
	PACIENTE("Paciênte"),
	MEDICO("Médico"),
	ATENDENTE("Atendente"),
	ADMINISTRADOR("Administrador");
	
	private final String descricao;
	
	TipoUsuario(final String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
}