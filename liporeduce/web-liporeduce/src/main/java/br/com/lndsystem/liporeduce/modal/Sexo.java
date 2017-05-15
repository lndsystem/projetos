package br.com.lndsystem.liporeduce.modal;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private final String descricao;
	
	Sexo (final String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
