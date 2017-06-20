package com.metasolucoes.prodkit.inspire.model;

public enum Ambiente {
	LEGADO ("Legado"),
	DESENVOLVIMENTO ("Desenvolvimento"),
	HOMOLOGACAO ("Homologação"),
	PRODUCAO ("Produção");
	
	private final String descricao;

	Ambiente(final String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}